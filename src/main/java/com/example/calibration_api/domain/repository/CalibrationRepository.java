package com.example.calibration_api.domain.repository;

import com.example.calibration_api.domain.model.Calibration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalibrationRepository extends JpaRepository<Calibration, Long> {

}
