package com.example.VaccineManagementApplication.Service;

import com.example.VaccineManagementApplication.DTO.DoseResponseDto;
import com.example.VaccineManagementApplication.Enum.DoseType;

public interface DoseService {

    DoseResponseDto addDose(DoseType doseType);
}
