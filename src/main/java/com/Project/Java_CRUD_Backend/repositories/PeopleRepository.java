package com.Project.Java_CRUD_Backend.repositories;

import com.Project.Java_CRUD_Backend.models.PeopleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<PeopleModel, Integer> {

    Optional<PeopleModel> findPeopleModelById(Long id);
}
