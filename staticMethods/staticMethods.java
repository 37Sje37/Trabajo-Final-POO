package staticMethods;

import java.util.Scanner;


import static ornaments.Colors.*;

public abstract interface staticMethods {




    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static int readOption(Scanner scanner, int min, int max, String prompt) {
        clearInputBuffer(); // Descarta cualquier pulsación acumulada durante la pausa
        int option = -1;
        while (option < min || option > max) {
            System.out.print(prompt);
            try {
                option = Integer.parseInt(scanner.nextLine().trim());
                if (option < min || option > max) {
                    System.out.println(BRIGHT_RED + "[SYSTEM ALERT] Sector out of bounds. Neural link requires a valid channel (" + min + "-" + max + ")." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(CRIMSON + "[NERVGEAR ERROR] Corrupted data packet. Input must be a numeric command (" + min + "-" + max + ")." + RESET);
            }
        }
        return option;
    }

    public static void clearInputBuffer() {
        try {
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (java.io.IOException e) {
            // Ignoramos si ocurre algún error de lectura al limpiar
        }
    }

}

