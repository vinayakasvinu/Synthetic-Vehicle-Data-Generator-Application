package com.tsystems.SyntheticVehicleDataGenerator.service;

import com.tsystems.SyntheticVehicleDataGenerator.model.VehicleData;

import java.util.List;

public interface VehicleService {
    List<VehicleData> getGeneratedData(int limit);
}
