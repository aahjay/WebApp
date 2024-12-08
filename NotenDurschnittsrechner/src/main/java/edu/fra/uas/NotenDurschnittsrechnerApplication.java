package edu.fra.uas;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import edu.fra.uas.controller.NotenController;

@SpringBootApplication
public class NotenDurschnittsrechnerApplication {

	// @Autowired
	// private NotenController notenController;

	public static void main(String[] args) {
		SpringApplication.run(NotenDurschnittsrechnerApplication.class, args);
	}

	/*
	 * @Bean
	 * CommandLineRunner init() {
	 * CommandLineRunner action = new CommandLineRunner() {
	 * 
	 * @Override
	 * public void run(String... args) throws Exception {
	 * /*notenController.addNote(1.0);
	 * notenController.addNote(1.2);
	 * notenController.addNote(2.3);
	 * notenController.addNote(3.0);
	 * notenController.fetchDurchschnitt();
	 */
	// }
	// };
	// return action;
	// }
}
