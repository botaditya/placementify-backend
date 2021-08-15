package com.hashcode.placementify.controller;

import com.hashcode.placementify.dto.StudentCodeDTO;
import com.hashcode.placementify.service.DataFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/verify/dataForm")
public class StudentDataFormController {
    private final DataFormService dataFormService;

    public StudentDataFormController(DataFormService dataFormService) {
        this.dataFormService = dataFormService;
    }

    @PostMapping("/verifyCode")
    public ResponseEntity<?> verifyCode(@Valid @RequestBody StudentCodeDTO studentCodeDTO){
        boolean code_valid = this.dataFormService.verifyCode(studentCodeDTO);
        if(code_valid) {
            return new ResponseEntity<>("Code verified successfully!", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Code verified successfully!", HttpStatus.NOT_FOUND);
    }
}
