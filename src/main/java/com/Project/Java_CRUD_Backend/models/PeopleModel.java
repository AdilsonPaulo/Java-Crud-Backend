package com.Project.Java_CRUD_Backend.models;

import com.Project.Java_CRUD_Backend.dtos.PeopleDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "people")
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class PeopleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    public PeopleModel(PeopleDTO peopleDTO){
        this.name = peopleDTO.name();
        this.description = peopleDTO.description();
    }
}
