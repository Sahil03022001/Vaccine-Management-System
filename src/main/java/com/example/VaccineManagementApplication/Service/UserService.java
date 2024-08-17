package com.example.VaccineManagementApplication.Service;

import com.example.VaccineManagementApplication.DTO.UserRequestDto;
import com.example.VaccineManagementApplication.DTO.UserResponseDto;
import com.example.VaccineManagementApplication.DTO.VaccinatedUserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getUserById(Integer id);

    VaccinatedUserResponseDto vaccinateUser(Integer id);
}
