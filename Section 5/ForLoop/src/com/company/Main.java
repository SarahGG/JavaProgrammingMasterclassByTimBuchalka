package com.company;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, -5, 7, 12, 17, 23, 2, 8, 6, 3};
        int count = 0;

//        for(int num : nums) {
        for(int num = 0; num < 50; num++) {
            if(num == 45) {
                break;
            }

            if(isPrime(num)) {
                System.out.println(num + " is a prime number.");
                count++;
            }
        }

        System.out.println("there were " + count + " prime numbers.");
    }

    private static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }

        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
