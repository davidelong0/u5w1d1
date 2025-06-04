package it.epicode.u5w1d1;

import it.epicode.u5w1d1.enumeration.StatoOrdine;
import it.epicode.u5w1d1.enumeration.StatoTavolo;
import it.epicode.u5w1d1.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class U5w1d1ApplicationTests {

	@Test
	@DisplayName("Test 1: Creazione di una PizzaBase")
	void testCreatePizzaBase() {
		PizzaBase margherita = new PizzaBase("Margherita", 5.0, 700);
		assertEquals("Margherita", margherita.getName());
		assertEquals(5.0, margherita.getPrice());
		assertEquals(700, margherita.getCalories());
	}

	@Test
	@DisplayName("Test 2: Calcolo prezzo e calorie di PizzaComposed")
	void testPizzaComposedPriceCalories() {
		PizzaBase base = new PizzaBase("Margherita", 5.0, 700);
		Topping mozzarella = new Topping("Mozzarella", 1.0, 150);
		Topping funghi = new Topping("Funghi", 1.5, 50);
		PizzaComposed pizza = new PizzaComposed("Pizza Funghi", base, List.of(mozzarella, funghi));

		assertEquals(7.5, pizza.getPrice(), 0.01);
		assertEquals(900, pizza.getCalories());
	}

	@Test
	@DisplayName("Test 3: Aggiunta item ad un ordine")
	void testAddItemToOrder() {
		Table t = new Table(1, 4, StatoTavolo.LIBERO);
		Order order = new Order(2, t, 2.0);
		Drink coke = new Drink("Coca-Cola", 2.0, 140);
		order.addItem(coke);
		assertEquals(1, order.toString().split("\\n").length - 7); // conta le righe degli item
	}

	@Test
	@DisplayName("Test 4: Calcolo totale ordine con coperti")
	void testOrderTotal() {
		Table t = new Table(1, 4, StatoTavolo.LIBERO);
		Order order = new Order(3, t, 2.0);
		Drink coke = new Drink("Coca-Cola", 2.0, 140);
		Topping olive = new Topping("Olive", 0.5, 50);
		PizzaBase base = new PizzaBase("Margherita", 5.0, 700);
		PizzaComposed pizza = new PizzaComposed("Pizza Olive", base, List.of(olive));
		order.addItem(coke);
		order.addItem(pizza);
		assertEquals(5.0 + 0.5 + 2.0 + (3 * 2.0), order.getTotale(), 0.01);
	}

	@ParameterizedTest
	@CsvSource({
			"Margherita,5.0,700",
			"Diavola,6.5,800",
			"Quattro Formaggi,7.0,900"
	})
	@DisplayName("Test 5 (Parametrico): Creazione PizzaBase con parametri diversi")
	void testPizzaBaseParameterized(String name, double price, int calories) {
		PizzaBase pizza = new PizzaBase(name, price, calories);
		assertEquals(name, pizza.getName());
		assertEquals(price, pizza.getPrice(), 0.01);
		assertEquals(calories, pizza.getCalories());
	}
}



