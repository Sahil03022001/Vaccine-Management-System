package com.example.VaccineManagementApplication.Controller;

import com.example.VaccineManagementApplication.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book-appointment")
    public String bookAppointment(@RequestParam("userId") Integer userId, @RequestParam("docId") Integer docId) {
        try {
            return appointmentService.bookAppointment(userId, docId);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
