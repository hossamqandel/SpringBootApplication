package com.google.application.api;

import com.google.application.model.Person;
import com.google.application.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(value = "api/v1/person")
@RestController
public class PersonController {

    private final PersonService mPersonService;

    @Autowired
    public PersonController(PersonService PersonService) {
        this.mPersonService = PersonService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        mPersonService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return mPersonService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return mPersonService.selectPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return mPersonService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        mPersonService.updatePersonById(id, personToUpdate);
    }
}
