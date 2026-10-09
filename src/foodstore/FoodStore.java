/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foodstore;
import java.util.Scanner;

public class FoodStore {


    public static void main(String[] args) {
        
        String lf = "LIFO";
        Scanner scanner = new Scanner(System.in);

        int option;

        do {

            System.out.println("\n===== FOOD STORAGE SYSTEM (Current system: " + lf + ")=====");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Peek Top Food");
            if (lf == "LIFO"){
                System.out.println("4. Modify system (LIFO / FIFO), change to --> FIFO");
            } else {
                System.out.println("4. Modify system (LIFO / FIFO), change to --> LIFO");
            }
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                option = 0;
            }

            switch (option) {

                case 1:
                    System.out.println("Add Food selected");
                    break;

                case 2:
                    System.out.println("Remove Food selected");
                    break;

                case 3:
                    System.out.println("Peek Top Food selected");
                    break;

                case 4:
                    System.out.println("Modify system selected");
                    if (lf == "LIFO"){
                        lf = "FIFO";
                    } else {
                        lf = "LIFO";
                    }
                    break;

                case 5:
                    System.out.println("Exit");
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }

        } while (option != 5);

        scanner.close();
    }
    
}
