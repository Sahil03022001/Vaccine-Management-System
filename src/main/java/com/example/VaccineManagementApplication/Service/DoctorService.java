package com.example.VaccineManagementApplication.Service;

import com.example.VaccineManagementApplication.DTO.AssociateDoctorDto;
import com.example.VaccineManagementApplication.DTO.DoctorRequestDto;
import com.example.VaccineManagementApplication.DTO.DoctorResponseDto;

public interface DoctorService {

    DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto);

    String associateDoctorWithVaccinationCentre(AssociateDoctorDto associateDoctorDto);
}
