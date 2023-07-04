package org.codegenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Code Generator!");

        while (true) {
            System.out.println("Please enter '1' to generate a code or '2' to validate a code:");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter the store number (1-200):");
                int storeNumber = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter the transaction number (1-9999):");
                int transactionNumber = Integer.parseInt(scanner.nextLine());

                String uniqueCode = CodeGenerator.generateUniqueCode(storeNumber, transactionNumber);
                System.out.println("Generated Code: " + uniqueCode);
            } else if (choice.equals("2")) {
                System.out.println("Enter a 9-character code:");
                String code = scanner.nextLine();

                String decodedInfo = CodeGenerator.decodeUniqueCode(code);
                System.out.println("Decoded Information:\n" + decodedInfo);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Do you want to continue? (y/n)");
            String continueChoice = scanner.nextLine();

            if (!continueChoice.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Thank you for using the Code Generator. Goodbye!");
    }
}
