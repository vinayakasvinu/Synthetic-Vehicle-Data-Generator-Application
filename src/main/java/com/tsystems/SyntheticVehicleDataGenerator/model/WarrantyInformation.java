package com.tsystems.SyntheticVehicleDataGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class WarrantyInformation {

    LocalDate warrantyStartDate;
    LocalDate warrantyEndDate;
    String coverage;
    String warrantyStatus;

}
