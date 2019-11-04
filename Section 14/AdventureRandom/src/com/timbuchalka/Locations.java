package com.timbuchalka;

import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

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
            for(Location location : locations.values()) { // for each of the locations write the id, desc, and exits
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder exitBuilder = loadExits(location);
                rao.writeUTF(exitBuilder.toString());

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
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            ra.readInt(); // it's there, gotta get it out of the way.
            long locationStartPoint = ra.readInt();

            while(ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }


        } catch (IOException e) {
            System.out.println("Our exception was caught!");
            e.printStackTrace();
        }
    }

    private static StringBuilder loadExits(Location location){
        StringBuilder exitBuilder = new StringBuilder(); // and all of the exits (built up below) ...
        for(String direction : location.getExits().keySet()) {
            if(!direction.equalsIgnoreCase("q")) {
                exitBuilder.append(direction);
                exitBuilder.append(",");
                exitBuilder.append(location.getExits().get(direction));
                exitBuilder.append(",");
                // direction,locationID,direction,locationID,...
            }
        }

        return exitBuilder;
    }

    Location getLocation(int locationID) throws IOException {
        IndexRecord record = index.get(locationID); // index has been loaded previous to this.
        // We are here collecting to location and it's record using the locationID that has been passed.
        ra.seek(record.getStartByte()); // beginning to search the file for the starting byte assigned to the record we just built.
        ra.readInt(); // reading the id number from the record, because it's there and we need to move past it.
        String description = ra.readUTF(); // reads the description. It knows how long the string is and when to stop
        // reading it because this is originally stored as it's length and THEN the string, so anything that reads it
        // knows how long the following string is.
        String exits = ra.readUTF(); // reading the string that is all the exits
        String[] exitPart = exits.split(","); // splits the exits variable, because of their delimiter.

        Location location = new Location(locationID, description, null); // creates the location object, but without exits

        if (locationID != 0) { // if our location isn't 0 (quit), proceed to load exits
            for (int i = 0; i < exitPart.length; i++) { // for each exit
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i+1]);
                String direction = exitPart[i]; // direction of this exit
                int destination = Integer.parseInt(exitPart[++i]); // destination of this exit is in the next index
                location.addExit(direction,destination); // adds the exit to our location object
            }
        }

        return location; // returns the location object
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

    void close() throws IOException {
        ra.close();
    }
}
