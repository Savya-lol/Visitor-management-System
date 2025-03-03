package com.savya.utilities;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            // Check that there is some input available
            if (!scanner.hasNext()) {
                throw new NoSuchElementException("No line found");
            }

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // consume newline left-over
                }
                return value;
            } else {
                System.out.print("Invalid input. Please enter a valid integer: ");
                scanner.next(); // consume invalid token
            }
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static String getPassword(String prompt) {
        System.out.print(prompt);
        return new String(System.console().readPassword());
    }

    public static double getDouble(String prompt) {
        System.out.print(prompt);
        while (true) {
            // Check that there is some input available
            if (!scanner.hasNext()) {
                throw new NoSuchElementException("No line found");
            }

            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // consume newline left-over
                }
                return value;
            } else {
                System.out.print("Invalid input. Please enter a valid double: ");
                scanner.next(); // consume invalid token
            }
        }
    }

    public static float getFloat(String prompt) {
        System.out.print(prompt);
        while (true) {
            // Check that there is some input available
            if (!scanner.hasNext()) {
                throw new NoSuchElementException("No line found");
            }

            if (scanner.hasNextFloat()) {
                float value = scanner.nextFloat();
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // consume newline left-over
                }
                return value;
            } else {
                System.out.print("Invalid input. Please enter a valid float: ");
                scanner.next(); // consume invalid token
            }
        }
    }

    public static long getLong(String prompt) {
        System.out.print(prompt);
        while (true) {
            // Check that there is some input available
            if (!scanner.hasNext()) {
                throw new NoSuchElementException("No line found");
            }

            if (scanner.hasNextLong()) {
                long value = scanner.nextLong();
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // consume newline left-over
                }
                return value;
            } else {
                System.out.print("Invalid input. Please enter a valid long: ");
                scanner.next(); // consume invalid token
            }
        }
    }

    public static int[] getIntArray() {
        int n = getInt("Enter number of elements: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getInt("Enter element " + (i + 1) + ": ");
        }
        return arr;
    }

}
