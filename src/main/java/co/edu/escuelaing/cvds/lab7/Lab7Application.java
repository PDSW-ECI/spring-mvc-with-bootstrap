package co.edu.escuelaing.cvds.lab7;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.ToDoItem;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import co.edu.escuelaing.cvds.lab7.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab7Application {
	@Autowired
	ToDoService toDoService;

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			System.out.println("Adding ToDoItem....");
			toDoService.addToDoItem(new ToDoItem(1, 1, "Hacer el Laboratorio 8", false));
			toDoService.addToDoItem(new ToDoItem(2, 1, "Hacer el laboratorio 7", true));
			toDoService.addToDoItem(new ToDoItem(3, 1, "Hacer el MVP para el primer Review", false));
		};
	}

}
