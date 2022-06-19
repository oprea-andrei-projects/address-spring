package com.example.addressspring.controller;

import com.example.addressspring.exceptions.SameAddressException;
import com.example.addressspring.exceptions.WrongIDException;
import com.example.addressspring.model.Address;
import com.example.addressspring.repository.AddressRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/address")
public class AddressController {

    private AddressRepo addressRepo;

    public AddressController(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @GetMapping("/allAdrs")
    public ResponseEntity<List<Address>>getAllAdrs(){

        List<Address> myadds = this.addressRepo.findAll();

        return new ResponseEntity<>(myadds, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addAddress")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){

        List<Address> myadds = this.addressRepo.findAll();

        if(Collections.frequency(myadds,address)>0){

            throw  new SameAddressException("Address already in");
        }

        return new ResponseEntity<>(address,HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){

        Address a1 = this.addressRepo.findById(address.getId()).get();
        a1.setCity_name(address.getCity_name());
        a1.setStreet_name(address.getStreet_name());
        a1.setStreet_number(address.getStreet_number());

        this.addressRepo.save(a1);

        return new ResponseEntity<>(a1, HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long id){

        Optional<Address>opt =this.addressRepo.findById(id);
        if(opt.isEmpty()){

            throw new WrongIDException("Nu ati introdus bine id-ul");
        }else{
            this.addressRepo.deleteById(id);
        }
        return new ResponseEntity<>(opt.get(), HttpStatus.ACCEPTED);
    }
}
