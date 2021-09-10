package com.hashcode.placementify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchDTO {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long buid;
    private String batchName;
    private int startYear;
    private int endYear;
    private double noOfStudents;
    private Long cuid;
}
