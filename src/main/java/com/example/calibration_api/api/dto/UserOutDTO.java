package com.example.calibration_api.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutDTO extends UserBaseDTO {

    private String name;
    private String email;
    private String password;
    private String userRole;
}
