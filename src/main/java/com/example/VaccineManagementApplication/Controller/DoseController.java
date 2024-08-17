package com.example.VaccineManagementApplication.Controller;

import com.example.VaccineManagementApplication.DTO.DoseResponseDto;
import com.example.VaccineManagementApplication.Enum.DoseType;
import com.example.VaccineManagementApplication.Service.DoseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {

    private final DoseService doseService;

    public DoseController(DoseService doseService) {
        this.doseService = doseService;
    }

    @PostMapping("/add/{doseType}")
    public ResponseEntity<DoseResponseDto> addDose(@PathVariable("doseType") DoseType doseType) {
        DoseResponseDto doseResponseDto = doseService.addDose(doseType);
        return new ResponseEntity<>(doseResponseDto, HttpStatus.CREATED);
    }
}
