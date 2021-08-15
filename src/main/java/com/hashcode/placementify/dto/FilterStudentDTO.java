package com.hashcode.placementify.dto;

import com.hashcode.placementify.model.MarkingScheme;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FilterStudentDTO {
    MarkingScheme sscMarkScheme;
    MarkingScheme hscMarkScheme;
    MarkingScheme gradMarkScheme;
    MarkingScheme currentMarkScheme;
    Double sscMarks;
    Double hscMarks;
    Double gradMarks;
    Double currentMarks;
    int gradPassoutYear;
    int currentPassoutYear;
}
