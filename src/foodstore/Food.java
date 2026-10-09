/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodstore;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Food {

    // Attributes
    protected double foodWeight;
    protected LocalDate foodDate;
    protected LocalDateTime foodTime;

    // Constructor
    public Food(double weight, LocalDate bestBeforeDate) {
        this.foodWeight = weight;
        this.foodDate = bestBeforeDate;
        this.foodTime = LocalDateTime.now();
    }
}
