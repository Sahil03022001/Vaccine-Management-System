package com.example.VaccineManagementApplication.DTO;

import com.example.VaccineManagementApplication.Enum.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponseDto {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String contactNo;
}
