package com.example.VaccineManagementApplication.DTO;

import com.example.VaccineManagementApplication.Enum.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String emailId;
    private String contactNo;
    private String panNo;
}
