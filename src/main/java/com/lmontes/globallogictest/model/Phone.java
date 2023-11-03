package com.lmontes.globallogictest.model;

import javax.validation.constraints.*;
import javax.persistence.*;
import lombok.*;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Integer cityCode;
    private String countryCode;

}
