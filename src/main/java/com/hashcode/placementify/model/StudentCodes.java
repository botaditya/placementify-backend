package com.hashcode.placementify.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_id",nullable = false,updatable = false)
    private long code_id;
    private String name;
    private String emailId;
    private String phoneNumber;
    private String code;
    private boolean active;
}
