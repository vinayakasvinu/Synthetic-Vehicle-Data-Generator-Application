package com.tsystems.SyntheticVehicleDataGenerator.controller;

import com.tsystems.SyntheticVehicleDataGenerator.model.VehicleData;
import com.tsystems.SyntheticVehicleDataGenerator.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SVDGController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicleData/{limit}")
    public List<VehicleData> getVehicleData(@PathVariable("limit") int limit){
        int i = limit < 0 ? 10 : limit;
        return this.vehicleService.getGeneratedData(i);
    }

}
