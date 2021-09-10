package com.hashcode.placementify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "batch")
public class Batch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buid",nullable = false,updatable = false)
    private long buid;

    private String batchName;
    private int startYear;
    private int endYear;
    private double noOfStudents;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "cuid")
    private Course course;

    @OneToMany(mappedBy = "batch")
    private Set<Student> studentsEnrolled=new HashSet<>();

    @Override
    public String toString() {
        return "Batch{" +
                "buid=" + buid +
                ", batchName='" + batchName + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}
