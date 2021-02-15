package com.alexmau.simpledbapp.controller;

import com.alexmau.simpledbapp.dto.Address;
import com.alexmau.simpledbapp.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping(AddressController.API_URL)
public class AddressController {

    protected static final String API_URL = "/address";

    @Autowired
    private AddressService addressService;

    @PostMapping()
    public ResponseEntity<Address> postEntity(@RequestBody @Valid Address address) {
        final Address result = addressService.add(address);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void putEntity(@PathVariable Long id, @RequestBody @Valid Address address) {
        addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntity(@PathVariable Long id) {
        addressService.delete(id);
    }
}
