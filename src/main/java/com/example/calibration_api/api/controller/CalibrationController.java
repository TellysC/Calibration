package com.example.calibration_api.api.controller;

import com.example.calibration_api.api.dto.CalibrationInputDTO;
import com.example.calibration_api.api.dto.CalibrationOutDTO;
import com.example.calibration_api.assembler.CalibrationAssembler;
import com.example.calibration_api.domain.service.CalibrationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/calibrations")
public class CalibrationController {

    private CalibrationAssembler calibrationAssembler;
    private CalibrationService calibrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CalibrationOutDTO add(@RequestBody @Valid CalibrationInputDTO calibrationInputDTO) {
        return calibrationAssembler.toDto(calibrationService.register(calibrationAssembler.toCalibration(calibrationInputDTO)));
    }

    @PutMapping("/{calibrationId}")
    public ResponseEntity<CalibrationOutDTO> update(@PathVariable final @NotNull Long calibrationId, @RequestBody final CalibrationInputDTO calibrationInputDTO) {
        return ResponseEntity.ok(calibrationAssembler.toDto(calibrationService.update(calibrationAssembler.toCalibration(calibrationInputDTO), calibrationId)));
    }

    @GetMapping("/{calibrationId}")
    public CalibrationOutDTO consult(@PathVariable final @NotNull Long calibrationId) {
        return calibrationAssembler.toDto(calibrationService.search(calibrationId));
    }

    @GetMapping
    public List<CalibrationOutDTO> list() {
        return calibrationAssembler.toCollectionDto(calibrationService.list());
    }
}
