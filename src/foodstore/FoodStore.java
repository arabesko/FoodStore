/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foodstore;
import java.time.LocalDate;
import java.util.Scanner;

public class FoodStore {


    public static void main(String[] args) {
        
        FoodRack myRack = new FoodRack();
        
        String lf = "LIFO";
        Scanner scanner = new Scanner(System.in);

        int option;

        do {

            System.out.println();
            System.out.println("========================================");
            System.out.println("          FOOD STORAGE SYSTEM");
            System.out.println("========================================");
            System.out.println("Current system: " + lf);
            System.out.println("----------------------------------------");
            System.out.println("1. Add Food");
            System.out.println("2. Remove Food");
            System.out.println("3. Peek Top Food");

            if ("LIFO".equals(lf)) {
                System.out.println("4. Change System (to FIFO)");
            } else {
                System.out.println("4. Change System (to LIFO)");
            }

            System.out.println("5. Display all elements");
            System.out.println("6. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Select an option (1-6): ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            } else {
                System.out.println();
                System.out.println("[ERROR] Please enter a valid number");
                scanner.nextLine();
                option = 0;
            }

            switch (option) {

                case 1:
                    //Add element to the storage
                    
                    //If the store is full 
                    if (myRack.FullStore()){
                       System.out.println("\n");
                       System.out.println("The storage is full, operation cancelated"); 
                       System.out.println("\n");
                       break;
                    }
                    
                    int foodType;
                    do {
                        // FOOD TYPE
                        System.out.println("----------------------------------------");
                        System.out.println("            SELECT FOOD TYPE");
                        System.out.println("----------------------------------------");
                        System.out.println("1. Burger");
                        System.out.println("2. Pizza");
                        System.out.println("3. Fries");
                        System.out.println("4. Sandwich");
                        System.out.println("5. Hotdog");
                        System.out.println("6. CANCEL OPERATION");
                        System.out.println("----------------------------------------");
                        System.out.print("Select an option (1-6): ");
                        
                        
                        if (scanner.hasNextInt()) {
                            foodType = scanner.nextInt();
                            if (foodType < 1 || foodType > 6) {
                                System.out.println();
                                System.out.println("[ERROR] Invalid option. Please select 1-6");
                                System.out.println();                            }
                        } else {
                            System.out.println();
                            System.out.println("[ERROR] Please enter a valid number.");
                            System.out.println();

                            scanner.next(); //Clean the scanner
                            foodType = 0;
                        }

                    } while (foodType < 1 || foodType > 6);
                    
                    if (foodType == 6) break;
                    
                    
                    //Input weight
                    double weight;
                    
                    System.out.println();
                    System.out.println("----------------------------------------");
                    System.out.println("              FOOD WEIGHT");
                    System.out.println("----------------------------------------");

                    do {
                        System.out.print("Enter food weight in grams: ");

                        if (scanner.hasNextDouble()) {
                            weight = scanner.nextDouble();

                            if (weight <= 0) {
                                System.out.println();
                                System.out.println("[ERROR] Weight must be greater than 0");
                                System.out.println();
                            }
                            
                        } else {
                            System.out.println();
                            System.out.println("[ERROR] Please enter a valid number");
                            System.out.println();
                            scanner.next();
                            weight = 0;
                        }

                    } while (weight <= 0);
                    
                    
                    
                    //Input Date
                    LocalDate bestBeforeDate = null;
                    boolean validDate = false;

                    System.out.println();
                    System.out.println("----------------------------------------");
                    System.out.println("            BEST BEFORE DATE");
                    System.out.println("----------------------------------------");

                    do {
                        System.out.print("Enter best before date (YYYY-MM-DD): ");
                        String dateInput = scanner.next();

                        try {
                            bestBeforeDate = LocalDate.parse(dateInput);

                            LocalDate today = LocalDate.now();

                            if (bestBeforeDate.isBefore(today)) {
                                System.out.println();
                                System.out.println("[ERROR] Date cannot be in the past.");
                                System.out.println();


                            } else if (bestBeforeDate.isAfter(today.plusDays(14))) {
                                System.out.println();
                                System.out.println("[ERROR] Date cannot exceed 14 days.");
                                System.out.println();

                            } else {
                                validDate = true;
                            }

                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println();
                            System.out.println("[ERROR] Invalid date. Use YYYY-MM-DD.");
                            System.out.println();
                        }

                    } while (!validDate);
                    
                    //Ellement added
                    myRack.AddFood(foodType, weight, bestBeforeDate);
                    System.out.println();
                    System.out.println("[SUCCESS] Food added successfully.");

                    break;

                case 2:
                    //Felete element of the storage
                    
                    System.out.println();
                    System.out.println("========================================");
                    System.out.println("              REMOVE FOOD");
                    System.out.println("========================================");
                    System.out.println();
                    
                    System.out.println("----------------------------------------");
                    System.out.println("Current system: " + lf);
                    System.out.println("----------------------------------------");
                    System.out.println();
                    
                    //Verify if the store have food
                    if ( myRack.PickAnyFood(lf) == null){
                        System.out.println("[WARNING] Storage is empty");
                        System.out.println("[CANCELLED] No food available to remove");
                        break;
                    }
                    
                    //Show the element that will be delete
                    System.out.println("----------------------------------------");
                    System.out.println("           FOOD TO BE REMOVED");
                    System.out.println("----------------------------------------");
                    System.out.println("Name         : " + myRack.PickAnyFood(lf).foodName);
                    System.out.println("Weight       : " + myRack.PickAnyFood(lf).foodWeight + " gr");
                    System.out.println("Best Before  : " + myRack.PickAnyFood(lf).foodDate);
                    System.out.println("----------------------------------------");
                    System.out.println();
                    
                    // Confirmation options
                    System.out.println("1. Confirm removal");
                    System.out.println("2. Cancel");
                    System.out.println("----------------------------------------");
                    
                    
                    //Confirm to delete the item
                    int confirm;
                    do {
                        System.out.println("\n");
                        System.out.print("Select an option (1-2): ");

                        if (scanner.hasNextInt()) {
                            confirm = scanner.nextInt();

                            if (confirm != 1 && confirm != 2) {
                                System.out.println();
                                System.out.println("[ERROR] Invalid option. Please select 1-2.");
                                System.out.println();
                            }

                        } else {
                            System.out.println();
                            System.out.println("[ERROR] Please enter a valid number.");
                            System.out.println();
                            
                            scanner.next();
                            confirm = 0;
                        }

                    } while (confirm != 1 && confirm != 2);
                    
                    if (confirm == 1) {
                        //Delete element
                        myRack.RemoveFood(lf);
                        
                        System.out.println();
                        System.out.println("[SUCCESS] Food removed successfully.");
                    } else {
                        //Cancel delete element
                        System.out.println();
                        System.out.println("[CANCELLED] Operation cancelled.");
                    }

                    break;
                    
                case 3:
                    //Pick the top element
                    
                    System.out.println();
                    System.out.println("========================================");
                    System.out.println("             PEEK TOP FOOD");
                    System.out.println("========================================");
                    System.out.println();
                    
                    //Verify if the store have food
                    if (myRack.PickAnyFood(lf) == null){
                        System.out.println("[WARNING] Storage is empty");
                        System.out.println("No food available to display");
                        break;
                    }
                    
                    //Show the element on the top
                    System.out.println("The element on the top is: " + "\n" +
                    myRack.PickAnyFood(lf).foodName + " with " + 
                    myRack.PickAnyFood(lf).foodWeight + "grs and the best before date: " +
                    myRack.PickAnyFood(lf).foodDate);
                    
                    System.out.println("----------------------------------------");
                    System.out.println("             TOP FOOD DETAILS");
                    System.out.println("----------------------------------------");
                    System.out.println("Current system: " + lf);
                    System.out.println();
                    System.out.println("Name         : " + myRack.PickAnyFood(lf).foodName);
                    System.out.println("Weight       : " + myRack.PickAnyFood(lf).foodWeight + " gr");
                    System.out.println("Best Before  : " + myRack.PickAnyFood(lf).foodWeight);
                    System.out.println("Time Added   : " + myRack.PickAnyFood(lf).foodDate);
                    System.out.println("----------------------------------------");
                    
                    break;

                case 4:
                    //Change between LIFO/FIFO
                    
                    System.out.println();
                    System.out.println("========================================");
                    System.out.println("             CHANGE SYSTEM");
                    System.out.println("========================================");
                    System.out.println();
                    
                    System.out.println("Previous system: " + lf);
                    
                    if (lf == "LIFO"){
                        lf = "FIFO";
                    } else {
                        lf = "LIFO";
                    }
                    
                    System.out.println("Current system : " + lf);
                    System.out.println("----------------------------------------");
                    System.out.println("[SUCCESS] System changed successfully.");
                    
                    break;
       
                case 5:
                    //Display all elements in the rack
                    if (myRack.storage.size() == 0) {
                        System.out.println("[WARNING] The food rack is empty.");
                        break;
                    }

                    System.out.println();
                    System.out.println("======================================================================");
                    System.out.println("                         FOOD RACK - " + lf);
                    System.out.println("======================================================================");

                    System.out.printf("%-7s %-15s %-12s %-15s %s%n",
                            "Index", "Food", "Weight (g)", "Expiry Date", "Element to pick");

                    System.out.println("----------------------------------------------------------------------");

                    for (int i = 0; i < myRack.storage.size(); i++) {

                        Food food = myRack.storage.get(i);

                        String nextToPick = "";

                        // Identify the next food to be removed
                        if ("LIFO".equals(lf) && i == myRack.storage.size() - 1) {
                            nextToPick = "<-- NEXT  TO PICK";
                        } else if ("FIFO".equals(lf) && i == 0) {
                            nextToPick = "<-- NEXT TO PICK";
                        }

                        System.out.printf("%-7d %-15s %-12.2f %-15s %s%n",
                                i + 1,
                                food.foodName,
                                food.foodWeight,
                                food.foodDate,
                                nextToPick);
                    }

                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Total: " + myRack.storage.size() + " / " + myRack.max_capacity);
                    System.out.println("======================================================================");
                    break;

                 case 6:
                    //Exit of the system
                    
                    System.out.println();
                    System.out.println("========================================");
                    System.out.println("              EXIT SYSTEM");
                    System.out.println("========================================");
                    System.out.println();
                    System.out.println("           Food Storage System           ");
                    System.out.println("            See you soon..!              ");
                    System.out.println();
                    System.out.println("----------------------------------------");
                    break;   
                    
                default:
                    System.out.println();
                    System.out.println("[ERROR] Invalid option. Please select 1-6.");
                    break;
            }

        } while (option != 6);

        scanner.close();
    }
}
