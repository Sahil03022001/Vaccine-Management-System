package com.example.VaccineManagementApplication.Models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "centres")
public class VaccinationCentre {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private LocalTime openingTime;
    private LocalTime closingTime;

    private String landLine_number;

    @OneToMany(mappedBy = "vaccinationCentre", cascade = CascadeType.ALL)
    List<Doctor> doctorList = new ArrayList<>();
}
