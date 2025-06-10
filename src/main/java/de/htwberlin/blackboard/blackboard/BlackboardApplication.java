package de.htwberlin.blackboard.blackboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BlackboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackboardApplication.class, args);
	}

}
