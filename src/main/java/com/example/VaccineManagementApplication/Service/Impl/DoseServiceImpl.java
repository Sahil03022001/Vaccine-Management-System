package com.example.VaccineManagementApplication.Service.Impl;

import com.example.VaccineManagementApplication.Convertors.DoseConvertor;
import com.example.VaccineManagementApplication.DTO.DoseResponseDto;
import com.example.VaccineManagementApplication.Enum.DoseType;
import com.example.VaccineManagementApplication.Models.Dose;
import com.example.VaccineManagementApplication.Repository.DoseRepository;
import com.example.VaccineManagementApplication.Service.DoseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoseServiceImpl implements DoseService {

    DoseRepository doseRepository;

    public DoseServiceImpl(DoseRepository doseRepository) {
        this.doseRepository = doseRepository;
    }

    //add new dose in database
    @Override
    public DoseResponseDto addDose(DoseType doseType) {
        Dose dose = DoseConvertor.makeDose(doseType);
        doseRepository.save(dose);

        //create the dose response Dto
        return DoseConvertor.makeDoseResponse(dose);
    }
}