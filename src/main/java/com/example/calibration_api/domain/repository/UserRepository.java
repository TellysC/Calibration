package com.example.calibration_api.domain.repository;

import com.example.calibration_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
