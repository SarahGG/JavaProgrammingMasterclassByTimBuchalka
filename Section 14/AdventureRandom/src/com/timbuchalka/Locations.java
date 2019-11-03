package com.timbuchalka;

import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {
            rao.writeInt(locations.size()); // loading locations on demand,
            // the file will remain open while the application runs

            int indexSize = locations.size() * 3 * Integer.BYTES; // giving an index size by taking the number of locations,
            // multiplying by 3 (because each will have 3 points of info,
            // then multiplying by the number of bytes in an integer

            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES); // calculate current position of the file pointer to the index size
            // to account for the value that we've already written to the file.
            // We also have to account for the integer that we're about to write to the file, the locations section offset that we just calculated.
            // Then we add the amount of bytes per Integer.
            // The file comes back as a long, but we want it to be an int.
            // You'd need to use long if the file was big enough, but that won't be needed now.

            rao.writeInt(locationStart); // the next thing is the index, but before we can write the index, we need to write the locations,
            // because each index record requires the offset for the location and we don't know what that offset will be until we've written that location.
            // We could write a location and then write the index, then loc/index/loc/index,
            // which takes a lot of jumping back and forth and is expensive in time and memory.

            long indexStart = rao.getFilePointer();
            int startPointer = locationStart; // used to calculate the locations record length after we've written it to the file
            rao.seek(startPointer); // finds that starting point ^ in the file, and then begins reading from there.
            // We only need to do this once, at the beginning, because we'll be writing sequentially from there.

            for(Location location : locations.values()) { // for each of the locations...

                rao.writeInt(location.getLocationID()); // get the location ID, ...
                rao.writeUTF(location.getDescription()); // the description ...

                StringBuilder builder = new StringBuilder(); // and all of the exits (built up below) ...
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                        // direction, locationID, direction, locationID, ...
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer)); // the startPointer, all the way to the current position,
                // to get a snapshot of the file as a record
                index.put(location.getLocationID(), record); // saves the this location with it's ID as the key and it's record that we've just built ^.
                startPointer = (int) rao.getFilePointer(); // updates the start pointer with the next location's beginning (which should be our current filePointer location).
            }
            rao.seek(indexStart);
            for (Integer locationID : index.keySet()) {
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());

            }
        }

    }

    // 1. This first four bytes will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long.  It will start at byte 8 and end at byte 1699
    // 4. The final section of the file will contain the location records (the data). It will start at byte 1700

    static {

        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");

                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }catch (InvalidClassException e) {
            System.out.println("We've found an InvalidClassException " + e.getMessage());
        } catch(IOException io) {
            System.out.println("We've found an IO Exception " + io.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("We've found a ClassNotFoundException " + e.getMessage());
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
