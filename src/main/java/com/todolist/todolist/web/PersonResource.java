package com.todolist.todolist.web;

import com.todolist.todolist.domain.Person;
import com.todolist.todolist.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonResource {//maybe just need to have one controller for person and task

    //injects the PersonRepository into this controller
    @Autowired
    private PersonRepository personRepository;

    //ResponseEntity is meant to represent the entire HTTP response, so in this case we want to return a list of all the Persons, so we should return a list
    @GetMapping
    //at the moment this get request returns all, not specific rows in the database
    public ResponseEntity<List<Person>> getAllPersons(){ //very likely there is an issue with this, as the demo example used lists in this, but we want all the individual elements in a table!!
        List<Person> persons = personRepository.findAll();
        return ResponseEntity.ok(persons); //ResponseEntity.ok(..) is a shortcut for creating a ResponseEntity with the given body and the OK status
    }
    @PostMapping
    //the @RequestBody is essentially the body of data that gets sent along with the request
    public void saveNewPerson(@RequestBody Person person){//will this method deal with new creations and also updating existing creations?
        personRepository.save(person);
//        if(id == null){
//            System.out.println("no id");
//            personRepository.save(person);
//        }else{
//            System.out.println("testing");
//            System.out.println(id);
//            System.out.println(person);
//            System.out.println(person.getName());
//            System.out.println(person.getId());
//            System.out.println(person.getTask().getDescription());
//            personRepository.findById(id)
//                    .map(p->{
//                        p.setName(person.getName());
////                        p.setTask(person.getTask()); //cant seem to just set the task like this, as it creates a new row in task instead of replacing the existing one
//                        return personRepository.save(p);
//                    });
//        }
    }
    @DeleteMapping("/{id}")
    public void deleteByPersonId(@PathVariable Long id){//path variable indicates that a method parameter should be bound to a URI path variable
        personRepository.deleteById(id);
    }

}
