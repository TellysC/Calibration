package com.example.calibration_api.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBaseDTO {

    @NotNull
    private Long id;
}
