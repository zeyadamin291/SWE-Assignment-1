package com.mycompany.amr_task_1;

import java.util.Scanner;

public class Amr_task_1 {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            boolean running = true;
            
            System.out.println("======= MULTI-UNIT CONVERTER =======");
            
            while (running) {
                System.out.println("\nSelect a Category:");
                System.out.println("1. Temperature (C <-> F)");
                System.out.println("2. Distance (KM <-> Miles)");
                System.out.println("3. Weight (KG <-> Lbs)");
                System.out.println("4. Exit");
                System.out.print("Choice: ");
                
                try {
                    String line = input.nextLine();
                    int choice = Integer.parseInt(line);
                    
                    switch (choice) {
                        case 1 -> convertTemperature(input);
                        case 2 -> convertDistance(input);
                        case 3 -> convertWeight(input);
                        case 4 -> {
                            running = false;
                            System.out.println("Goodbye!");
                        }
                        default -> System.out.println("Invalid choice. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid number.");
                }
            }
        }
    }

    public static void convertTemperature(Scanner sc) {
        System.out.print("Enter 1 for C->F or 2 for F->C: ");
        try {
            int sub = Integer.parseInt(sc.nextLine());
            System.out.print("Enter value: ");
            double val = Double.parseDouble(sc.nextLine());
            if(sub == 1) System.out.printf("%.2f C is %.2f F%n", val, (val * 9/5) + 32);
            else System.out.printf("%.2f F is %.2f C%n", val, (val - 32) * 5/9);
        } catch (NumberFormatException e) { System.out.println("Invalid input."); }
    }

    public static void convertDistance(Scanner sc) {
        System.out.print("Enter 1 for KM->Miles or 2 for Miles->KM: ");
        try {
            int sub = Integer.parseInt(sc.nextLine());
            System.out.print("Enter value: ");
            double val = Double.parseDouble(sc.nextLine());
            if(sub == 1) System.out.printf("%.2f KM is %.2f Miles%n", val, val * 0.621371);
            else System.out.printf("%.2f Miles is %.2f KM%n", val, val / 0.621371);
        } catch (NumberFormatException e) { System.out.println("Invalid input."); }
    }

    public static void convertWeight(Scanner sc) {
        System.out.print("Enter 1 for KG->Lbs or 2 for Lbs->KG: ");
        try {
            int sub = Integer.parseInt(sc.nextLine());
            System.out.print("Enter value: ");
            double val = Double.parseDouble(sc.nextLine());
            if(sub == 1) System.out.printf("%.2f KG is %.2f Lbs%n", val, val * 2.20462);
            else System.out.printf("%.2f Lbs is %.2f KG%n", val, val / 2.20462);
        } catch (NumberFormatException e) { System.out.println("Invalid input."); }
    }
}