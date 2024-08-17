package com.example.VaccineManagementApplication.Convertors;

import com.example.VaccineManagementApplication.DTO.UserRequestDto;
import com.example.VaccineManagementApplication.DTO.UserResponseDto;
import com.example.VaccineManagementApplication.DTO.VaccinatedUserResponseDto;
import com.example.VaccineManagementApplication.Models.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConvertor {

    public static User userRequestDtoToUser(UserRequestDto userRequestDto) {
        return User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .gender(userRequestDto.getGender())
                .contactNo(userRequestDto.getContactNo())
                .emailId(userRequestDto.getEmailId())
                .panNo(userRequestDto.getPanNo())
                .build();
    }

    public static UserResponseDto userToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .emailId(user.getEmailId())
                .contactNo(user.getContactNo())
                .panNo(user.getPanNo())
                .build();
    }

    public static VaccinatedUserResponseDto makeVaccinatedUserResponseDto(User user) {
        return VaccinatedUserResponseDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .contactNo(user.getContactNo())
                .emailId(user.getEmailId())
                .doseType(user.getDose().getDoseType())
                .vaccinatedDate(String.valueOf(user.getDose().getVaccinationDate()))
                .build();
    }
}
