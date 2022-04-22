package it.philmark.docenza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PhilmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhilmarkApplication.class, args);
	}

}
