package com.tsystems.SyntheticVehicleDataGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceHistory {
    private String serviceDescription;
    private LocalDate serviceDate;
}
