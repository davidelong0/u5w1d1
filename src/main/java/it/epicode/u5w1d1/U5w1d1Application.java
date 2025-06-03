package it.epicode.u5w1d1;

import it.epicode.u5w1d1.model.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class U5w1d1Application implements CommandLineRunner {

	private final ApplicationContext context;

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
	}
}
