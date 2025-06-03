package it.epicode.u5w1d1.model;

import lombok.Getter;

import java.util.List;

@Getter
public class PizzaComposed implements Item {
    private final String name;
    private final PizzaBase base;
    private final List<Topping> toppings;

    public PizzaComposed(String name, PizzaBase base, List<Topping> toppings) {
        this.name = name;
        this.base = base;
        this.toppings = toppings;
    }

    @Override
    public double getPrice() {
        return base.getPrice() + toppings.stream().mapToDouble(Topping::getPrice).sum();
    }

    @Override
    public int getCalories() {
        return base.getCalories() + toppings.stream().mapToInt(Topping::getCalories).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " - €" + getPrice() + " - " + getCalories() + " kcal\n");
        sb.append("Base: ").append(base.getName()).append("\n");
        for (Topping t : toppings) {
            sb.append("  ").append(t).append("\n");
        }
        return sb.toString();
    }
}

