package com.example.VaccineManagementApplication.Service.Impl;

import com.example.VaccineManagementApplication.Convertors.UserConvertor;
import com.example.VaccineManagementApplication.DTO.UserRequestDto;
import com.example.VaccineManagementApplication.DTO.UserResponseDto;
import com.example.VaccineManagementApplication.DTO.VaccinatedUserResponseDto;
import com.example.VaccineManagementApplication.Enum.DoseType;
import com.example.VaccineManagementApplication.Exception.InvalidContactNoException;
import com.example.VaccineManagementApplication.Exception.InvalidEmailIdException;
import com.example.VaccineManagementApplication.Exception.InvalidPanNumberException;
import com.example.VaccineManagementApplication.Exception.UserNotFoundException;
import com.example.VaccineManagementApplication.Models.Dose;
import com.example.VaccineManagementApplication.Models.User;
import com.example.VaccineManagementApplication.Repository.DoseRepository;
import com.example.VaccineManagementApplication.Repository.UserRepository;
import com.example.VaccineManagementApplication.Service.UserService;
import com.example.VaccineManagementApplication.Validations.Validation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DoseRepository doseRepository;

    public UserServiceImpl(UserRepository userRepository, DoseRepository doseRepository) {
        this.doseRepository = doseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        if(!Validation.validateContactNo(userRequestDto.getContactNo())) {
            throw new InvalidContactNoException("Contact number not valid");
        }

        if(!Validation.validateEmail(userRequestDto.getEmailId())) {
            throw new InvalidEmailIdException("Email id not valid");
        }

        if(!Validation.validatePanNumber(userRequestDto.getPanNo())) {
            throw new InvalidPanNumberException("Pan number not valid");
        }

        User user = UserConvertor.userRequestDtoToUser(userRequestDto);
        userRepository.save(user);

        //create the User Response
        return UserConvertor.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return UserConvertor.userToUserResponseDto(user.get());
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public VaccinatedUserResponseDto vaccinateUser(Integer id) {
        Optional<User> userPresent = userRepository.findById(id);
        if(userPresent.isPresent()) {
            User user = userPresent.get();

            Dose dose = user.getDose();
            DoseType doseType = dose == null ? null : dose.getDoseType();
            DoseType reqDose = null;

            if(doseType == null)
                reqDose = DoseType.DOSE1;
            else if (doseType.equals(DoseType.DOSE2))
                throw new RuntimeException("User is already vaccinated with both the doses");
            else
                reqDose = DoseType.DOSE2;

            List<Dose> doseList = doseRepository.findAll();
            for(Dose dose1 : doseList) {
                if(!dose1.isUsed() && dose1.getDoseType().equals(reqDose)) {
                    dose1.setUsed(true);
                    dose1.setVaccinationDate(LocalDateTime.now());
                    dose1.setUser(user);
                    user.setDose(dose1);

                    //create vaccinated user response dto
                    return UserConvertor.makeVaccinatedUserResponseDto(user);
                }
            }

            throw new RuntimeException("No Dose available");

        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
