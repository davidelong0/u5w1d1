
package it.epicode.u5w1d1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Drink implements Item {
    private String name;
    private double price;
    private int calories;

    @Override
    public String toString() {
        return name + " - €" + price + " - " + calories + " kcal";
    }
}


