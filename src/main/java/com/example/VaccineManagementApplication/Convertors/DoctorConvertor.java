package com.example.VaccineManagementApplication.Convertors;

import com.example.VaccineManagementApplication.DTO.DoctorRequestDto;
import com.example.VaccineManagementApplication.DTO.DoctorResponseDto;
import com.example.VaccineManagementApplication.Models.Doctor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DoctorConvertor {

    public static Doctor doctorRequestToDoctor(DoctorRequestDto doctorRequestDto) {
        return Doctor.builder()
                .firstName(doctorRequestDto.getFirstName())
                .lastName(doctorRequestDto.getLastName())
                .age(doctorRequestDto.getAge())
                .gender(doctorRequestDto.getGender())
                .contactNo(doctorRequestDto.getContactNo())
                .build();
    }

    public static DoctorResponseDto doctorToDoctorResponse(Doctor doctor) {
        return DoctorResponseDto.builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .age(doctor.getAge())
                .gender(doctor.getGender())
                .contactNo(doctor.getContactNo())
                .build();
    }
}