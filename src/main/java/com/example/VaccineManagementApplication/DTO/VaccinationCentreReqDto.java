package com.example.VaccineManagementApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationCentreReqDto {

    private String openingTime;
    private String closingTime;
    private String landLine_number;
}
