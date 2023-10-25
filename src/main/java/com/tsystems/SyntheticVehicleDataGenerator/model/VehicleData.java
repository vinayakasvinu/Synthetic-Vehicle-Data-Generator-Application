package com.tsystems.SyntheticVehicleDataGenerator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleData {
    @JsonProperty(index = 1)
    String VIN;
    @JsonProperty(index = 2)
    String VehicleRegistrationNumber;
    @JsonProperty(index = 3)
    LocalDate VehicleRegistrationDate;
    @JsonProperty(index = 4)
    String EngineNumber;
    @JsonProperty(index = 5)
    String Brand;
    @JsonProperty(index = 6)
    String Model;
    @JsonProperty(index = 7)
    String VehicleExteriorColor;
    @JsonProperty(index = 8)
    String VehicleInteriorColor;

    @JsonProperty(index = 9)
    LocalDate ManufacturingDate;
    @JsonProperty(index = 10)
    String VehicleType;
    @JsonProperty(index = 11)
    String EmissionClass;
    @JsonProperty(index = 12)
    Double OdometerReading;
    @JsonProperty(index = 13)
    String EngineType;
    @JsonProperty(index = 14)
    String TransmissionType;
    @JsonProperty(index = 15)
    List<ServiceHistory> serviceHistory;
    @JsonProperty(index = 16)
    Double Price;
    @JsonProperty(index = 17)
    List<OwnershipRecord> OwnershipHistory;
    @JsonProperty(index = 18)
    WarrantyInformation warrantyInformation;
    @JsonProperty(index = 19)
    DealerInformation SellingDealer;
    @JsonProperty(index = 20)
    List<String> FeaturesAndOptions;
    @JsonProperty(index = 21)
    int YearOfTheVehicle;
    @JsonProperty(index = 22)
    String VehicleCondition;
    @JsonProperty(index = 23)
    String VehicleLocation;
    @JsonProperty(index = 24)
    String Status;



}
