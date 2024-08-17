package com.example.VaccineManagementApplication.DTO;

import com.example.VaccineManagementApplication.Enum.DoseType;
import com.example.VaccineManagementApplication.Enum.Gender;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaccinatedUserResponseDto {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String contactNo;
    private String emailId;
    private DoseType doseType;
    private String vaccinatedDate;
}
