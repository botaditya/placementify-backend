package com.hashcode.placementify.service;

import com.hashcode.placementify.dto.StudentCodeDTO;
import com.hashcode.placementify.repository.DataFormRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class DataFormService {
    private final DataFormRepository dataFormRepository;

    public DataFormService(DataFormRepository dataFormRepository) {
        this.dataFormRepository = dataFormRepository;
    }

    public boolean verifyCode(StudentCodeDTO studentCodeDTO){
        return this.dataFormRepository.findByCodeAndEmailId(studentCodeDTO.getCode().strip(), studentCodeDTO.getEmailId().strip().toLowerCase(Locale.ROOT));
    }
}
