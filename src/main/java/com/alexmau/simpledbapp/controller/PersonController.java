package com.alexmau.simpledbapp.controller;

import com.alexmau.simpledbapp.dto.Person;
import com.alexmau.simpledbapp.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(PersonController.API_URL)
public class PersonController {

    protected static final String API_URL = "/person";

    @Autowired
    private PersonService personService;

    @PostMapping()
    public ResponseEntity<Person> postEntity(@RequestBody @Valid Person person) {
        final Person result = personService.add(person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> putEntity(@PathVariable Long id, @RequestBody @Valid Person person) {
        final Person result = personService.update(id, person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntity(@PathVariable Long id) {
        personService.delete(id);
    }

    @GetMapping()
    public ResponseEntity<List<Person>> getAll() {
        final List<Person> result = personService.getAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        long result = personService.count();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
