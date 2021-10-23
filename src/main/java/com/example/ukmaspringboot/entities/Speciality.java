package com.example.ukmaspringboot.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialityId;
    private String name;
    Speciality(){}

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality(String name) {
        this.name = name;
    }
}
