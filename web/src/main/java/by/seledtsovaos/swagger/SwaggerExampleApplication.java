package by.seledtsovaos.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Used to configure and start the application.
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class SwaggerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerExampleApplication.class, args);
    }

}
