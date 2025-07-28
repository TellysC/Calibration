package com.example.calibration_api.assembler;

import com.example.calibration_api.api.dto.CalibrationInputDTO;
import com.example.calibration_api.api.dto.CalibrationOutDTO;
import com.example.calibration_api.domain.model.Calibration;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CalibrationAssembler {

    private ModelMapper modelMapper;

    public Calibration toCalibration(final CalibrationInputDTO calibrationInputDTO) {
        return modelMapper.map(calibrationInputDTO, Calibration.class);
    }

    public CalibrationOutDTO toDto(final Calibration calibration) {
        return modelMapper.map(calibration, CalibrationOutDTO.class);
    }

    public List<CalibrationOutDTO> toCollectionDto(final List<Calibration> calibrations) {
        return calibrations.stream()
                .map(this::toDto)
                .toList();
    }
}
