package com.knightsnexus.GalaxyStoreAPI.seeders;

import com.github.javafaker.Faker;
import com.knightsnexus.GalaxyStoreAPI.model.Product;
import com.knightsnexus.GalaxyStoreAPI.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ProductSeeder implements CommandLineRunner {

    private final ProductRepository repo;

    public ProductSeeder(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {

        Faker faker = new Faker();

        if(repo.count() == 0) {

            for(int i = 0; i < 100; i++) {

                Product p = new Product();

                p.setName(faker.commerce().productName());

                p.setPrice(
                        Double.parseDouble(
                                faker.commerce().price()
                        )
                );

                repo.save(p);
            }

            System.out.println("🔥 100 Products Generated");
        }
    }
}
