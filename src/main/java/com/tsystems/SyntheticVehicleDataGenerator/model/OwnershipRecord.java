package com.tsystems.SyntheticVehicleDataGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OwnershipRecord {

    private String ownerName;
    private Address ownerAddress;
    private LocalDate purchaseDate;
    private LocalDate saleDate;
    private float ownershipDuration;
}
