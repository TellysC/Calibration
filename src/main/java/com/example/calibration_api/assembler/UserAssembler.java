package com.example.calibration_api.assembler;

import com.example.calibration_api.api.dto.UserInputDTO;
import com.example.calibration_api.api.dto.UserOutDTO;
import com.example.calibration_api.domain.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserAssembler {

    private ModelMapper modelMapper;

    public User toUser(final UserInputDTO userInputDTO){
        return modelMapper.map(userInputDTO, User.class);
    }

    public UserOutDTO toDto(final User user) {
        return modelMapper.map(user, UserOutDTO.class);
    }

    public List<UserOutDTO> toCollectionDto(final List<User> users) {
        return users.stream()
                .map(this::toDto)
                .toList();
    }
}
