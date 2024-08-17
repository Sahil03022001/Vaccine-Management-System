package com.example.VaccineManagementApplication.Controller;

import com.example.VaccineManagementApplication.DTO.AssociateDoctorDto;
import com.example.VaccineManagementApplication.DTO.DoctorRequestDto;
import com.example.VaccineManagementApplication.DTO.DoctorResponseDto;
import com.example.VaccineManagementApplication.Service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctorRequestDto) {
        DoctorResponseDto doctorResponseDto;
        try {
            doctorResponseDto = doctorService.addDoctor(doctorRequestDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(doctorResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/associate-doctor-with-vaccination-centre")
    public ResponseEntity<String> associateDoctorWithVaccinationCentre(@RequestBody AssociateDoctorDto associateDoctorDto) {
        try {
            String message = doctorService.associateDoctorWithVaccinationCentre(associateDoctorDto);
            return new ResponseEntity<>(message, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
