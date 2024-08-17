package com.example.VaccineManagementApplication.Controller;

import com.example.VaccineManagementApplication.DTO.UserRequestDto;
import com.example.VaccineManagementApplication.DTO.UserResponseDto;
import com.example.VaccineManagementApplication.DTO.VaccinatedUserResponseDto;
import com.example.VaccineManagementApplication.Models.User;
import com.example.VaccineManagementApplication.Service.UserService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto;
        try {
            userResponseDto = userService.createUser(userRequestDto);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Integer id) {
        UserResponseDto userResponseDto;
        try {
            userResponseDto = userService.getUserById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PostMapping("/vaccinateUser/{id}")
    public ResponseEntity vaccinateUser(@PathVariable("id") Integer id) {
        VaccinatedUserResponseDto vaccinatedUserResponseDto;
        try {
            vaccinatedUserResponseDto = userService.vaccinateUser(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(vaccinatedUserResponseDto, HttpStatus.OK);
    }
}
