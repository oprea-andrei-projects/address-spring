package com.example.addressspring;

import com.example.addressspring.model.Address;
import com.example.addressspring.repository.AddressRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressSpringApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(AddressRepo addressRepo){
//
//
//        return args -> {
//
//            Faker faker = new Faker();
//
//            for (int i = 0; i < 10; i++) {
//
//                Address address = new Address(faker.address().streetName(),
//                        faker.address().streetAddressNumber(),faker.address().cityName());
//
//
//                addressRepo.save(address);
//
//
//
//            }
//
//        };
//    }
}
