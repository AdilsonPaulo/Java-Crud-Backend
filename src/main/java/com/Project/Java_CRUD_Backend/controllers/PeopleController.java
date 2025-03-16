package com.Project.Java_CRUD_Backend.controllers;

import com.Project.Java_CRUD_Backend.dtos.PeopleDTO;
import com.Project.Java_CRUD_Backend.models.PeopleModel;
import com.Project.Java_CRUD_Backend.repositories.PeopleRepository;
import com.Project.Java_CRUD_Backend.services.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@CrossOrigin("*")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @GetMapping
    public ResponseEntity<List<PeopleModel>> getAllPeople(){
        List<PeopleModel> people = this.peopleService.getAllPeople();

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PeopleModel> createPeople(@RequestBody PeopleDTO peopleDTO){
        PeopleModel newPeople = this.peopleService.createPeople(peopleDTO);

        return new ResponseEntity<>(newPeople, HttpStatus.CREATED);
    }

    @PutMapping("{Id}")
    public ResponseEntity<PeopleModel> updatePeople(@PathVariable Long Id, @RequestBody PeopleDTO peopleDTO) throws Exception {
        PeopleModel updatePeople = this.peopleService.updatePeople(Id, peopleDTO);

        return new ResponseEntity<>(updatePeople, HttpStatus.OK);
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> deletePeople(@PathVariable Long Id) throws Exception {
        this.peopleService.deletePeople(Id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
