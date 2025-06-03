package it.epicode.u5w1d1;

import it.epicode.u5w1d1.enumeration.StatoOrdine;
import it.epicode.u5w1d1.enumeration.StatoTavolo;
import it.epicode.u5w1d1.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class U5w1d1Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(U5w1d1Application.class);

	private final ApplicationContext context;

	@Value("${pizzeria.costoCoperto}")
	private double costoCoperto;

	public U5w1d1Application(ApplicationContext context) {
		this.context = context;
	}

	public static void main(String[] args) {
		SpringApplication.run(U5w1d1Application.class, args);
	}

	@Override
	public void run(String... args) {
		Menu menu = context.getBean(Menu.class);
		menu.printMenu();

		Table tavolo1 = new Table(1, 4, StatoTavolo.LIBERO);
		logger.info("Creato un tavolo con stato LIBERO: {}", tavolo1);

		if (tavolo1.getStato() == StatoTavolo.LIBERO) {

			tavolo1.setStato(StatoTavolo.OCCUPATO);
			logger.info("Cambiato lo stato del tavolo in OCCUPATO all’inizio dell’ordine: {}", tavolo1);

			Order ordine1 = new Order(2, tavolo1, costoCoperto);


			ordine1.setStato(StatoOrdine.IN_CORSO);
			logger.info("Ordine creato con stato IN_CORSO: {}", ordine1);


			ordine1.addItem(menu.getPizzas().get(0));     // Pizza Margherita
			ordine1.addItem(menu.getToppings().get(1));   // Ham
			ordine1.addItem(menu.getDrinks().get(0));     // Lemonade

			logger.info("Dettagli ordine con elementi aggiunti:\n{}", ordine1);


			ordine1.setStato(StatoOrdine.PRONTO);
			logger.info("Ordine pronto per essere servito (stato PRONTO): {}", ordine1);


			ordine1.setStato(StatoOrdine.SERVITO);
			logger.info("Ordine servito (stato SERVITO): {}", ordine1);


			tavolo1.setStato(StatoTavolo.LIBERO);
			logger.info("Tavolo liberato dopo il servizio: {}", tavolo1);

		} else {
			logger.warn("Impossibile creare ordine: il tavolo è già occupato!");
		}
	}
}

