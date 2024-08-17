package com.example.VaccineManagementApplication.DTO;

import com.example.VaccineManagementApplication.Enum.DoseType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoseResponseDto {

    private String uniqueDoseId;
    private DoseType doseType;
    private boolean isUsed;
    private LocalDateTime vaccinatedDate;
}
