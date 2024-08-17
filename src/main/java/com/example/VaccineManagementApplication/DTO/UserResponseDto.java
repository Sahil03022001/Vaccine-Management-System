package com.example.VaccineManagementApplication.DTO;

import com.example.VaccineManagementApplication.Enum.Gender;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String contactNo;
    private String emailId;
    private String panNo;
}
