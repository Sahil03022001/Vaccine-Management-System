package com.example.VaccineManagementApplication.Models;

import com.example.VaccineManagementApplication.Enum.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "doctors")
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String contactNo;

    @ManyToOne
    @JoinColumn
    private VaccinationCentre vaccinationCentre;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();
}
