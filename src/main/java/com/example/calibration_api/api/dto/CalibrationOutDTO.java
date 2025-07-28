package com.example.calibration_api.api.dto;

import com.example.calibration_api.domain.enums.CalibrationPeriodicity;
import com.example.calibration_api.domain.enums.CalibrationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalibrationOutDTO extends CalibrationBaseDTO {

    private String description;
    private CalibrationPeriodicity periodicity;
    private LocalDate date;
    private LocalDate nextDate;
    private CalibrationStatus status;
    private UserOutDTO user;

}
