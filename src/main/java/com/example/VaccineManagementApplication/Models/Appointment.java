package com.example.VaccineManagementApplication.Models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate appointment_date;
    private LocalTime appointment_time;

    @JoinColumn
    @ManyToOne
    private Doctor doctor;

    @JoinColumn
    @ManyToOne
    private User user;
}