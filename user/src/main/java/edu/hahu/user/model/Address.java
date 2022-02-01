package edu.hahu.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String city;
    private String zipCode;
}
