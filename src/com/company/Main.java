package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); Scanner sc2 = new Scanner(System.in);
        boolean looping = true; boolean looping2 = true;
        String response; String input = "";
        int [] RGB = new int [3];
        while (looping) {
            System.out.println("Are you inputting a color, a RGB triplet, or a hexadecimal?");
            System.out.println("Type in \"color\", \"rgb\", or \"hex\"?");
            response = sc.next().toLowerCase();
            if (response.equals("color")) {
                looping = false;
                System.out.println("Input color.");
                input = sc2.nextLine().toLowerCase();
                Conversion.searchColor(input);

            } else if (response.equals("rgb")) {
                looping = false;
                for (int i = 0; i < RGB.length; i++) {
                    while (looping2) {
                        if (i == 0) {
                            System.out.println("Input RGB value for Red (0-255, both numbers inclusive).");
                        } else if (i == 1) {
                            System.out.println("Input RGB value for Green (0-255, both numbers inclusive).");
                        } else {
                            System.out.println("Input RGB value for Blue (0-255, both numbers inclusive).");
                        }
                        RGB[i] = sc2.nextInt();
                        if (RGB[i] < 0 || RGB[i] > 255) {
                            System.out.println("RGB value is either higher than 255 or lower than 0.");
                        } else {
                            looping2 = false;
                        }
                    }
                    looping2 = true;
                }
                Conversion.convertRGBIntoHex(RGB);

            } else if (response.equals("hex")) {
                looping = false;
                while (looping2) {
                    System.out.println("Input hexadecimal.");
                    input = sc2.nextLine().toLowerCase();
                    if (input.length() == 6) {
                        looping2 = false;
                    } else {
                        System.out.println("The hexadecimal inputted is not 6 characters in length.");
                    }
                }
                Conversion.convertHexIntoRGB(input);

            } else {
                System.out.println("Invalid answer. Please input a valid answer.\n");
            }
        }
    }
}
