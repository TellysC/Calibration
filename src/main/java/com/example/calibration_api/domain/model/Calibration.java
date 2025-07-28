package com.example.calibration_api.domain.model;

import com.example.calibration_api.domain.enums.CalibrationPeriodicity;
import com.example.calibration_api.domain.enums.CalibrationStatus;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "calibrations")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Calibration {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CalibrationPeriodicity periodicity;
    private String description;
    @Enumerated(EnumType.STRING)
    private CalibrationStatus status;
    private LocalDate date;
    private LocalDate nextDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void calculateNextDate() {
        if (date == null || periodicity == null) return;

        switch (periodicity) {
            case TRIMESTRAL:
                nextDate = date.plusMonths(3);
                break;
            case SEMESTRAL:
                nextDate = date.plusMonths(6);
                break;
            case ANUAL:
                nextDate = date.plusYears(1);
                break;
        }
    }

    public void updateStatus() {
        if (nextDate == null) {
            status = null;
            return;
        }

        LocalDate hoje = LocalDate.now();

        if (hoje.isAfter(nextDate)) {
            status = CalibrationStatus.VENCIDO;
        } else if (!hoje.isBefore(nextDate.minusMonths(1))) {
            status = CalibrationStatus.PROXIMO_DO_VENCIMENTO;
        } else {
            status = CalibrationStatus.CALIBRADO;
        }
    }

    public void updateCalibrationInfo() {
        calculateNextDate();
        updateStatus();
    }
}
