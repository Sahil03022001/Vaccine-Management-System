package com.example.VaccineManagementApplication.Service.Impl;

import com.example.VaccineManagementApplication.DTO.VaccinationCentreReqDto;
import com.example.VaccineManagementApplication.Models.VaccinationCentre;
import com.example.VaccineManagementApplication.Repository.VaccinationCentreRepository;
import com.example.VaccineManagementApplication.Service.VaccinationCentreService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class VaccinationCentreServiceImpl implements VaccinationCentreService {

    VaccinationCentreRepository vaccinationCentreRepository;

    public VaccinationCentreServiceImpl(VaccinationCentreRepository vaccinationCentreRepository) {
        this.vaccinationCentreRepository = vaccinationCentreRepository;
    }

    @Override
    public void addCentre(VaccinationCentreReqDto vaccinationCentreReqDto) {
        VaccinationCentre vaccinationCentre = new VaccinationCentre();
        vaccinationCentre.setOpeningTime(LocalTime.parse(vaccinationCentreReqDto.getOpeningTime()));
        vaccinationCentre.setClosingTime(LocalTime.parse(vaccinationCentreReqDto.getClosingTime()));
        vaccinationCentre.setLandLine_number(vaccinationCentreReqDto.getLandLine_number());
        vaccinationCentreRepository.save(vaccinationCentre);
    }
}
