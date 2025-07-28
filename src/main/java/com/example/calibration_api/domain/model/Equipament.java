package com.example.calibration_api.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipaments")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Equipament {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}
