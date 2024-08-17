package com.example.VaccineManagementApplication.Controller;

import com.example.VaccineManagementApplication.DTO.VaccinationCentreReqDto;
import com.example.VaccineManagementApplication.Service.VaccinationCentreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centre")
public class VaccinationCentreController {

    VaccinationCentreService vaccinationCentreService;

    public VaccinationCentreController(VaccinationCentreService vaccinationCentreService) {
        this.vaccinationCentreService = vaccinationCentreService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCentre(@RequestBody VaccinationCentreReqDto vaccinationCentreReqDto) {
        vaccinationCentreService.addCentre(vaccinationCentreReqDto);
        return new ResponseEntity<>("Centre Added", HttpStatus.CREATED);
    }
}
