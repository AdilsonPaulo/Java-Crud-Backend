package com.Project.Java_CRUD_Backend.services;

import com.Project.Java_CRUD_Backend.dtos.PeopleDTO;
import com.Project.Java_CRUD_Backend.models.PeopleModel;
import com.Project.Java_CRUD_Backend.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    public PeopleService(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    private PeopleRepository peopleRepository;

    public PeopleModel createPeople(PeopleDTO peopleDTO){
        PeopleModel newPeople = new PeopleModel(peopleDTO);
        this.savePeople(newPeople);

        return newPeople;
    }

    public void savePeople(PeopleModel people){
        this.peopleRepository.save(people);
    }

    public List<PeopleModel> getAllPeople(){
        return this.peopleRepository.findAll();
    }

    public void deletePeople(Long Id) throws Exception {
        PeopleModel peopleModel = getPeopleById(Id);
        this.peopleRepository.delete(peopleModel);
    }

    public PeopleModel getPeopleById(Long Id) throws Exception {
        return this.peopleRepository.findPeopleModelById(Id).orElseThrow(() -> new Exception("ERRO!"));
    }

    public PeopleModel updatePeople(Long Id, PeopleDTO peopleDTO) throws Exception {
        PeopleModel peopleModel = this.getPeopleById(Id);
        peopleModel.setName(peopleDTO.name());
        peopleModel.setDescription(peopleDTO.description());

        return peopleModel;
    }
}
