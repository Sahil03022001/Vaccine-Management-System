package com.example.VaccineManagementApplication.Models;

import com.example.VaccineManagementApplication.Enum.DoseType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Dose {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(unique = true)
    private String doseId;

    @Enumerated(EnumType.STRING)
    private DoseType doseType;

    private boolean isUsed;

    private LocalDateTime vaccinationDate;

    @OneToOne
    @JoinColumn
    private User user;
}
