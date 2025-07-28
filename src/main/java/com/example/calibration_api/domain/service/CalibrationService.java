package com.example.calibration_api.domain.service;

import com.example.calibration_api.domain.model.Calibration;
import com.example.calibration_api.domain.repository.CalibrationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CalibrationService {

    private CalibrationRepository calibrationRepository;

    @Transactional
    public Calibration register(final Calibration calibration) {
        calibration.updateCalibrationInfo();
        return calibrationRepository.save(calibration);
    }

    @Transactional
    public Calibration update(final Calibration calibration, final Long id) {

        Calibration existingCalibration = search(id);
        existingCalibration.setDescription(calibration.getDescription());
        existingCalibration.setDate(calibration.getDate());
        existingCalibration.setPeriodicity(calibration.getPeriodicity());
        existingCalibration.updateCalibrationInfo();
        return calibrationRepository.save(existingCalibration);
    }

    @Transactional
    public Calibration search(final Long id) {
        return calibrationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calibration with id " + id + " not found"));
    }

    @Transactional
    public List<Calibration> list() {
        return calibrationRepository.findAll();
    }
}
