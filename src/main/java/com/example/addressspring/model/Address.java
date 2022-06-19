package com.example.addressspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street_name;
    private String street_number;
    private String city_name;

    public Address(String street_name, String street_number, String city_name) {
        this.street_name = street_name;
        this.street_number = street_number;
        this.city_name = city_name;
    }

    @Override
    public boolean equals (Object o){

        Address a = (Address) o;

       return this.getCity_name().equals(a.getCity_name())
               &&this.getStreet_name().equals(a.getStreet_name())
        &&this.getStreet_number().equals(a.getStreet_number());
    }
}
