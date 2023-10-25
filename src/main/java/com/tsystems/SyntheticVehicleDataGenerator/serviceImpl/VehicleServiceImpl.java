package com.tsystems.SyntheticVehicleDataGenerator.serviceImpl;

import com.tsystems.SyntheticVehicleDataGenerator.model.VehicleData;
import com.tsystems.SyntheticVehicleDataGenerator.service.VehicleService;
import com.tsystems.SyntheticVehicleDataGenerator.util.SyntheticData;
import com.tsystems.SyntheticVehicleDataGenerator.util.VehicleDataUtilMethods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class VehicleServiceImpl implements VehicleService {

    public List<VehicleData> getGeneratedData(int limit) {
        VehicleDataUtilMethods utilMethods = new VehicleDataUtilMethods();
        Random rnd = new Random();
        ArrayList<VehicleData> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            VehicleData data = new VehicleData();
            data.setSellingDealer(utilMethods.dealerGenerator());
            data.setVIN(utilMethods.vinGenerator());
            data.setEngineNumber(utilMethods.engNoGenerator());
            data.setOwnershipHistory(utilMethods.getOwners());
            data.setManufacturingDate(utilMethods.manufacturingDateGenerator(data));
            data.setVehicleRegistrationDate(utilMethods.getRegDate(data));
            data.setVehicleRegistrationNumber(utilMethods.regNoGenerator());
            data.setVehicleExteriorColor(SyntheticData.colors[rnd.nextInt(SyntheticData.colors.length)]);
            data.setVehicleInteriorColor(SyntheticData.colors[rnd.nextInt(SyntheticData.colors.length)]);
            int temp = rnd.nextInt(SyntheticData.brands.length);
            data.setBrand(SyntheticData.brands[temp]);
            data.setModel(SyntheticData.models[temp]);
            data.setPrice(utilMethods.priceGenerator(data));
            data.setVehicleType(SyntheticData.vehilceType[rnd.nextInt(SyntheticData.vehilceType.length)]);
            data.setTransmissionType(SyntheticData.trasmissionType[rnd.nextInt(SyntheticData.trasmissionType.length)]);
            data.setEngineType(SyntheticData.engineType[rnd.nextInt(SyntheticData.engineType.length)]);
            data.setEmissionClass(SyntheticData.emissionClass[rnd.nextInt(SyntheticData.emissionClass.length)]);
            data.setYearOfTheVehicle(utilMethods.getYearOfVehicle(data));
            data.setStatus(SyntheticData.status[rnd.nextInt(SyntheticData.status.length)]);
            data.setServiceHistory(utilMethods.serviceHistoryGenerator(data));
            data.setOdometerReading(utilMethods.odometerReadingGenerator(data));
            data.setWarrantyInformation(utilMethods.warrantyInfoGenerator(data));
            data.setVehicleCondition(utilMethods.vehicleConditionGenerator(data));
            data.setFeaturesAndOptions(utilMethods.fAndOGenerator(data));
            data.setVehicleLocation(data.getSellingDealer().getDealerAddress().getCity());
            list.add(data);
        }
        return list;
    }
}