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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String contactNo;

    @Column(unique = true)
    private String emailId;

    @Column(unique = true)
    private String panNo;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Dose dose;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();
}