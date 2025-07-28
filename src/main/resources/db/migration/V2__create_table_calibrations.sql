CREATE TABLE calibrations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    periodicity ENUM('TRIMESTRAL', 'SEMESTRAL', 'ANUAL') NOT NULL,
    description VARCHAR(600),
    status ENUM('CALIBRADO', 'PROXIMO_DO_VENCIMENTO', 'VENCIDO'),
    date DATE,
    next_date DATE,
    user_id BIGINT NOT NULL
);
