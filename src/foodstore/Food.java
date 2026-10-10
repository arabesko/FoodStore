/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstore;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Food {

    // Attributes
    protected String foodName;
    protected double foodWeight;
    protected LocalDate foodDate;
    protected LocalDateTime foodTime;

    // Constructor
    public Food(String name, double weight, LocalDate bestBeforeDate) {
        this.foodName = name;
        this.foodWeight = weight;
        this.foodDate = bestBeforeDate;
        this.foodTime = LocalDateTime.now();
    }
}
