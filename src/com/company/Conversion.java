package com.company;

import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class Conversion {

    public static void searchColor (String color) throws IOException {
        int [] RGB = new int [3];
        boolean specific = false;

        File colors = new File("src/Colors.txt");
        Scanner checkColors = new Scanner(colors);
        while (checkColors.hasNext()) {
            String line = checkColors.nextLine();
            String [] divisions = line.split("\\s+");
            divisions[0] = divisions[0].toLowerCase();
            if (divisions[0].equals(color.toLowerCase())) {
                specific = true;

                RGB[0] = Integer.parseInt(divisions[1].substring(0, 2), 16);
                RGB[1] = Integer.parseInt(divisions[1].substring(2, 4), 16);
                RGB[2] = Integer.parseInt(divisions[1].substring(4, 6), 16);

                System.out.println("COLOR: " + divisions[0].toUpperCase());
                System.out.println("HEXADECIMAL: " + divisions[1]);
                System.out.println("RGB VALUES: " + RGB[0] + ", " + RGB[1] + ", " + RGB[2]);
                break;
            }
        }
        if (!specific) {
            System.out.println("No data found.");
        }
    }

    public static void convertRGBIntoHex (int [] RGB) throws IOException {
        String hex;
        String [] hexValues = new String [3];
        hexValues[0] = Integer.toHexString(RGB[0]);
        hexValues[1] = Integer.toHexString(RGB[1]);
        hexValues[2] = Integer.toHexString(RGB[2]);
        hex = hexValues[0] + hexValues[1] + hexValues[2];
        System.out.println("\nHEXADECIMAL: " + hex);
        System.out.println("RGB VALUES: " + RGB[0] + ", " + RGB[1] + ", " + RGB[2]);

        boolean specific = false;

        File colors = new File("src/Colors.txt");
        Scanner checkColors = new Scanner(colors);
        while (checkColors.hasNext()) {
            String line = checkColors.nextLine();
            String [] divisions = line.split("\\s+");
            if (divisions[1].equals(hex.toLowerCase())) {
                specific = true;
                System.out.println("COLOR: " + divisions[0]);
                break;
            }
        }
        if (!specific) {
            System.out.println("COLOR: No specific color associated.");
        }
    }

    public static void convertHexIntoRGB (String hex) throws IOException {
        int [] RGB = new int [3];
        RGB[0] = Integer.parseInt(hex.substring(0, 2), 16);
        RGB[1] = Integer.parseInt(hex.substring(2, 4), 16);
        RGB[2] = Integer.parseInt(hex.substring(4, 6), 16);

        System.out.println("\nHEXADECIMAL: " + hex);
        System.out.println("RGB VALUES: " + RGB[0] + ", " + RGB[1] + ", " + RGB[2]);

        boolean specific = false;

        File colors = new File("src/Colors.txt");
        Scanner checkColors = new Scanner(colors);
        while (checkColors.hasNext()) {
            String line = checkColors.nextLine();
            String [] divisions = line.split("\\s+");
            if (divisions[1].equals(hex.toLowerCase())) {
                specific = true;
                System.out.println("COLOR: " + divisions[0]);
                break;
            }
        }
        if (!specific) {
            System.out.println("COLOR: No specific color associated.");
        }
    }
}
