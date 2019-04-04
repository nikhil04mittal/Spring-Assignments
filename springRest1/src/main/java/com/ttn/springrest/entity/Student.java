package com.ttn.springrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Size(min = 5, message = "At least 5 characters")
    private String name;
    private Integer age;
    private Long contact;

    public Student(String name, Integer age, Long contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "com.ttn.springrest.entity.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}