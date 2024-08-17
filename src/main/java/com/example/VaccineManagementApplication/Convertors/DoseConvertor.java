package com.example.VaccineManagementApplication.Convertors;

import com.example.VaccineManagementApplication.DTO.DoseResponseDto;
import com.example.VaccineManagementApplication.Enum.DoseType;
import com.example.VaccineManagementApplication.Models.Dose;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class DoseConvertor {

    public static Dose makeDose(DoseType doseType) {
        String uniqueDoseId = String.valueOf(UUID.randomUUID());
        return Dose.builder()
                .doseId(uniqueDoseId)
                .isUsed(false)
                .doseType(doseType)
                .build();
    }

    public static DoseResponseDto makeDoseResponse(Dose dose) {
        return DoseResponseDto.builder()
                .uniqueDoseId(dose.getDoseId())
                .isUsed(dose.isUsed())
                .doseType(dose.getDoseType())
                .vaccinatedDate(dose.getVaccinationDate())
                .build();
    }
}
