package com.example.calibration_api.config;

import com.example.calibration_api.domain.model.Calibration;
import com.example.calibration_api.domain.repository.CalibrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
public class CalibrationStatusUpdater {

    private CalibrationRepository calibrationRepository;

    @Scheduled(cron = "0 0 1 * * ?")
    @Transactional
    public void updateCalibrationStatus() {
        List<Calibration> calibrations = calibrationRepository.findAll();
        for (Calibration calibration : calibrations) {
            calibration.updateCalibrationInfo();
        }
        calibrationRepository.saveAll(calibrations);
    }
}
