package com.example.VaccineManagementApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssociateDoctorDto {

    private int docId;
    private int centreId;
}
