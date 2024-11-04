package observer.pattern.main;

import observer.pattern.observers.Customer;
import observer.pattern.publisher.Store;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(Store store) {
        return args -> {
            Customer customer1 = new Customer("Alice");
            Customer customer2 = new Customer("Bob");

            store.addObserver(customer1);
            store.addObserver(customer2);

            store.setMessage("New item available!");

            store.removeObserver(customer1);

            store.setMessage("Another item available!");
        };
    }
}