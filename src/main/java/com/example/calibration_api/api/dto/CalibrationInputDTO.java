package com.example.calibration_api.api.dto;

import com.example.calibration_api.domain.enums.CalibrationPeriodicity;
import com.example.calibration_api.domain.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalibrationInputDTO {

    @NotBlank
    @Size(min = 2, max = 600)
    private String description;
    @NotNull
    private CalibrationPeriodicity periodicity;
    @NotNull
    private LocalDate date;
    @Valid
    @NotNull
    private UserBaseDTO user;
}