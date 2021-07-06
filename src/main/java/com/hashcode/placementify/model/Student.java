package com.hashcode.placementify.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "suid",nullable = false,updatable = false)
    private long suid;
    @ManyToOne
    @JoinColumn(name ="cuid_foreign", referencedColumnName = "cuid", insertable = false, updatable = false, nullable = false)
    private Course course;
    @ManyToOne
    @JoinColumn(name ="buid_foreign", referencedColumnName = "buid", insertable = false, updatable = false, nullable = false)
    private Batch batch;
    private String nameBySSC;
    private String emaiId;
    private String phoneNumber;
    private String whatsappNumber;
    private String gender;
    private Date dateOfBirth;
    private String currentState;
    private String currentCity;
    private String homeState;
    private String homeCity;
    private String languagesKnown;
    private String currentCourse;
    private String currentBatch;
    private String currentInstitute;
    private String postgrad;
    private String dreamCompanies;
    private String gradCourse;
    private double gradCGPA;
    private String gradYear;
    private double gradPercent;
    private String gradInstitute;
    private String gradUniversity;
    private String gradCityState;
    private double hscPercent;
    private double hscCGPA;
    private String hscYear;
    private double sscPercent;
    private double sscCGPA;
    private String sscYear;
    private String gap;
    private int yearsOfGap;
    private String workExp;
    private int yearsOfExp;
    private String companyName;
    private String companyLoc;
    @Column(nullable = false, updatable = false)
    private String formId;

}
