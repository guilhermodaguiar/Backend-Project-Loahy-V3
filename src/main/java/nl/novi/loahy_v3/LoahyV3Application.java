package nl.novi.loahy_v3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
public class LoahyV3Application {

	public static void main(String[] args) {
		SpringApplication.run(LoahyV3Application.class, args);
	}

}
