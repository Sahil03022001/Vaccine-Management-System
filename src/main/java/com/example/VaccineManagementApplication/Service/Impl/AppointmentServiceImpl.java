package com.example.VaccineManagementApplication.Service.Impl;

import com.example.VaccineManagementApplication.Exception.DoctorNotFoundException;
import com.example.VaccineManagementApplication.Exception.UserNotFoundException;
import com.example.VaccineManagementApplication.Models.Appointment;
import com.example.VaccineManagementApplication.Models.Doctor;
import com.example.VaccineManagementApplication.Models.User;
import com.example.VaccineManagementApplication.Repository.AppointmentRepository;
import com.example.VaccineManagementApplication.Repository.DoctorRepository;
import com.example.VaccineManagementApplication.Repository.UserRepository;
import com.example.VaccineManagementApplication.Service.AppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    AppointmentRepository appointmentRepository;
    DoctorRepository doctorRepository;
    UserRepository userRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  UserRepository userRepository,
                                  DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
        this.doctorRepository = doctorRepository;
    }


    @Override
    public String bookAppointment(Integer userId, Integer docId) {

        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        Optional<Doctor> doctorOptional = doctorRepository.findById(docId);
        if(doctorOptional.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found");
        }

        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();

        //create appointment object
        Appointment appointment = new Appointment();
        appointment.setAppointment_date(LocalDate.now());
        appointment.setAppointment_time(LocalTime.now());

        //set the doctor and user for appointment
        appointment.setDoctor(doctor);
        appointment.setUser(user);
        user.getAppointmentList().add(appointment);
        doctor.getAppointmentList().add(appointment);

        //save the appointment first to avoid duplicate entries when saving user and doctor
        appointmentRepository.save(appointment);

        userRepository.save(user);
        doctorRepository.save(doctor);

        return "Appointment Booked";
    }
}