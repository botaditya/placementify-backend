package com.hashcode.placementify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuid",nullable = false,updatable = false)
    private Long cuid;
    private String courseName;
    private String coursePattern;
    private int courseDuration;
    private String courseUniversity;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Batch> batches=new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "cuid=" + cuid +
                ", courseName='" + courseName + '\'' +
                ", coursePattern='" + coursePattern + '\'' +
                ", courseDuration=" + courseDuration +
                ", courseUniversity='" + courseUniversity + '\'' +
                '}';
    }
}
