package com.example.VaccineManagementApplication.Service.Impl;

import com.example.VaccineManagementApplication.Convertors.DoctorConvertor;
import com.example.VaccineManagementApplication.DTO.AssociateDoctorDto;
import com.example.VaccineManagementApplication.DTO.DoctorRequestDto;
import com.example.VaccineManagementApplication.DTO.DoctorResponseDto;
import com.example.VaccineManagementApplication.Exception.DoctorNotFoundException;
import com.example.VaccineManagementApplication.Exception.InvalidContactNoException;
import com.example.VaccineManagementApplication.Models.Doctor;
import com.example.VaccineManagementApplication.Models.VaccinationCentre;
import com.example.VaccineManagementApplication.Repository.DoctorRepository;
import com.example.VaccineManagementApplication.Repository.VaccinationCentreRepository;
import com.example.VaccineManagementApplication.Service.DoctorService;
import com.example.VaccineManagementApplication.Validations.Validation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    DoctorRepository doctorRepository;
    VaccinationCentreRepository vaccinationCentreRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, VaccinationCentreRepository vaccinationCentreRepository) {
        this.doctorRepository = doctorRepository;
        this.vaccinationCentreRepository = vaccinationCentreRepository;
    }

    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {
        if(!Validation.validateContactNo(doctorRequestDto.getContactNo())) {
            throw new InvalidContactNoException("Contact no. is not valid");
        }

        Doctor doctor = DoctorConvertor.doctorRequestToDoctor(doctorRequestDto);
        doctorRepository.save(doctor);

        //make the response dto of doctor
        return DoctorConvertor.doctorToDoctorResponse(doctor);
    }

    @Override
    public String associateDoctorWithVaccinationCentre(AssociateDoctorDto associateDoctorDto) {

        Optional<Doctor> doctorOptional = doctorRepository.findById(associateDoctorDto.getDocId());
        if(doctorOptional.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        }

        Optional<VaccinationCentre> centreOptional = vaccinationCentreRepository.findById(associateDoctorDto.getDocId());
        if(centreOptional.isEmpty()) {
            throw new DoctorNotFoundException("Vaccination Centre not found");
        }

        Doctor doctor = doctorOptional.get();
        VaccinationCentre vaccinationCentre = centreOptional.get();

        doctor.setVaccinationCentre(vaccinationCentre);
        vaccinationCentre.getDoctorList().add(doctor);

        vaccinationCentreRepository.save(vaccinationCentre);

        return "Doctor associated to Given Vaccination Centre";
    }
}
