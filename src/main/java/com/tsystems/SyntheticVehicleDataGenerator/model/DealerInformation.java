package com.tsystems.SyntheticVehicleDataGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealerInformation {
    private String dealerName;
    private Address dealerAddress;
    private String gstNo;

}
