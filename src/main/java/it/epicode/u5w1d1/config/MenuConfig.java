package it.epicode.u5w1d1.config;

import it.epicode.u5w1d1.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MenuConfig {

    // === PIZZA BASE ===
    @Bean
    public PizzaBase margherita() {
        return new PizzaBase("Pizza Margherita", 4.99, 1104);
    }

    // === TOPPINGS ===
    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 0.69, 92);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 0.99, 35);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 0.69, 22);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 0.79, 24);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 0.99, 86);
    }

    // === DRINKS ===
    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade (0.33l)", 1.29, 128);
    }

    @Bean
    public Drink water() {
        return new Drink("Water (0.5l)", 1.29, 0);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine (0.75l, 13%)", 7.49, 607);
    }

    // === MENU ===
    @Bean
    public Menu menu() {
        // Composed Pizzas
        PizzaComposed hawaiian = new PizzaComposed("Hawaiian Pizza",
                margherita(), List.of(ham(), pineapple()));

        PizzaComposed salamiPizza = new PizzaComposed("Salami Pizza",
                margherita(), List.of(salami()));

        return new Menu(
                List.of(margherita(), hawaiian, salamiPizza), // Pizzas
                List.of(cheese(), ham(), onions(), pineapple(), salami()), // Toppings
                List.of(lemonade(), water(), wine()) // Drinks
        );
    }
}


