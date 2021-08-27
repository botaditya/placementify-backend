package com.hashcode.placementify.model;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

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
    private String emailId;
    private String whatsappNumber;
    private String phoneNumber;
    private String parentPhone;
    private String parentCompany;
    private String gender;
    private Date dateOfBirth;
    private String bloodGroup;
    @Value("false")
    private boolean handicapped;
    private String CasteCategory;
    private String aadharNumber;
    private String panNumber;
    private String languagesKnown;

    private String currentState;
    private String currentCity;
    private String homeState;
    private String homeCity;

    private String currentCourse;
    private String currentBatch;
    private String currentCourseUnivPRN;
    //filter param
    private String currentCourseMarkingScheme;
    private double currentCourseScore;
    //filter param
    private String currentCoursePassoutYear;

    private String currentCourseInstitute;
    private String currentCourseUniversity;

    private boolean postgrad;
    private String postgradCourse;

    private String dreamCompanies;
    private String areaOfExpertise;

    private String gradCourse;
    private String gradSeatNo;
    private String gradUnivPRN;
    private String gradYear;
    //filter param
    private String gradMarkingScheme;
    private double gradScore;
    private String gradInstitute;
    private String gradUniversity;
    private String gradCityState;

    private String hscCeatNo;
    //filter param
    private String hscMarkingScheme;
    private double hscScore;
    private String hscYear;

    private String sscCeatNo;
    //filter param
    private String sscMarkingScheme;
    private double sscScore;
    private String sscYear;

    //filter param
    @Value("false")
    private boolean gap;
    @Value("0")
    private int yearsOfGap;

    @Value("false")
    private boolean workExp;
    @Value("0")
    private int yearsOfExp;
    @Value("-")
    private String companyName;
    @Value("-")
    private String companyLoc;

    //FILE PARAM { MARKSHEETS, RESUME, PHOTO }

    @Column(length = 500000)
    private byte[] resume;
    @Column(length = 250000)
    private byte[] photo;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false, updatable = false)
    private String applicationId;
}
