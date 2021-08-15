package com.hashcode.placementify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Batch")
public class Batch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buid",nullable = false,updatable = false)
    private long buid;
    private long cuid;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="cuid_foreign", referencedColumnName = "cuid", insertable = false, updatable = false, nullable = false)
    private Course course;
    private String batchName;
    private int startYear;
    private int endYear;
    private double noOfStudents;
    @JsonIgnore
    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students=new HashSet<>();

    @Override
    public String toString() {
        return "Batch{" +
                "buid=" + buid +
                ", cuid=" + cuid +
                ", course=" + course +
                ", batchName='" + batchName + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}
