/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstore;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

public class FoodRack {
    

    // Featurs
    int max_capacity = 10; //Max capacity
    List<Food> storage= new ArrayList<Food>(); //storage will be food type
    public int count;

    // Constructor
    public FoodRack() {
        count = 0;
    }
    
    public void AddFood(String lf, int option, double weight, LocalDate dateFood){
        if (storage.size() < 10){
            //Thay are more space for food
            storage.add(MyFood(option, weight, dateFood));
        }
        
    }
    
    public void RemoveFood(String lf){
        if (count == 0){
            //Clean the element in index 0
            
        }
        
    }
    
    public void PickTopFood(String lf) {
        //Pick the top 10 element
        
    }
    
    Food MyFood(int myFoodOption, double weight, LocalDate dateFood){
        switch (myFoodOption){
            case 1:
                //Burger
                return new Burger(weight, dateFood);
            case 2:
                //Pizza
                return new Pizza(weight, dateFood);
            case 3:
                //Fries
                return new Fries(weight, dateFood);
            case 4:
                //Sandwich
                return new Sandwich(weight, dateFood);
            case 5:
                //Hotdog
                return new Hotdog(weight, dateFood);
        }
        return null;
    }
    
    
    //Herencia
    // Burger class
    public static class Burger extends Food {

        public Burger(double weight, LocalDate bestBeforeDate) {
            super(weight, bestBeforeDate);
        }
    }

    // Pizza class
    public static class Pizza extends Food {

        public Pizza(double weight, LocalDate bestBeforeDate) {
            super(weight, bestBeforeDate);
        }
    }

    // Fries class
    public static class Fries extends Food {

        public Fries(double weight, LocalDate bestBeforeDate) {
            super(weight, bestBeforeDate);
        }
    }

    // Sandwich class
    public static class Sandwich extends Food {

        public Sandwich(double weight, LocalDate bestBeforeDate) {
            super(weight, bestBeforeDate);
        }
    }

    // Hotdog class
    public static class Hotdog extends Food {

        public Hotdog(double weight, LocalDate bestBeforeDate) {
            super(weight, bestBeforeDate);
        }
    }
    
}
