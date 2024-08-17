package com.example.VaccineManagementApplication.DTO;

import com.example.VaccineManagementApplication.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequestDto {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String contactNo;
}
