package it.epicode.u5w1d1.model;

import java.util.List;

public class Menu {
    private final List<Item> pizzas;
    private final List<Topping> toppings;
    private final List<Drink> drinks;

    public Menu(List<Item> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public void printMenu() {
        System.out.println("--------- Esempio Menù ---------\n");

        printSection("Pizzas", pizzas);
        printSection("Toppings", toppings);
        printSection("Drinks", drinks);
    }

    private void printSection(String sectionName, List<? extends Item> items) {
        System.out.printf("%-25s %-10s %-10s\n", sectionName, "Calories", "Price");
        for (Item item : items) {
            System.out.printf("%-25s %-10d €%-9.2f\n", item.getName(), item.getCalories(), item.getPrice());
        }
        System.out.println();
    }
}
