package com.tsystems.SyntheticVehicleDataGenerator.util;

import com.tsystems.SyntheticVehicleDataGenerator.model.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class VehicleDataUtilMethods {
    Random rnd = new Random();

    // generate random vin
    public String vinGenerator() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 17; i++) {
            sb.append(SyntheticData.string.charAt(rnd.nextInt(SyntheticData.string.length())));
        }
        return sb.toString();
    }

    // generate random registration number
    public String regNoGenerator() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(SyntheticData.string.charAt(rnd.nextInt(SyntheticData.string.length())));
        }
        return sb.toString();
    }

    // generate random engine number
    public String engNoGenerator() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(SyntheticData.string.charAt(rnd.nextInt(SyntheticData.string.length())));
        }
        return sb.toString();
    }

    // generate random first name
    public String getFirstName() {
        return SyntheticData.firstNames[rnd.nextInt(SyntheticData.firstNames.length)];
    }

    //generate random last name
    public String getLastName() {
        return SyntheticData.lastNames[rnd.nextInt(SyntheticData.lastNames.length)];
    }

    //generate random color
    public String getColor() {
        return SyntheticData.colors[rnd.nextInt(SyntheticData.colors.length)];
    }

    //generate random addresss
    public Address getAddress() {
        Address address = new Address();
        address.setBuilding(SyntheticData.buildings[rnd.nextInt(SyntheticData.buildings.length)]);
        int temp = rnd.nextInt(SyntheticData.cities.length);
        address.setCity(SyntheticData.cities[temp]);
        address.setState(SyntheticData.states[temp]);
        address.setCountry("India");
        address.setStreet(SyntheticData.streets[rnd.nextInt(SyntheticData.streets.length)]);
        address.setCountry("India");
        address.setPin(SyntheticData.pins[rnd.nextInt(SyntheticData.pins.length)]);
        return address;
    }

    // generate random engine number
    public String gstNoGenerator() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(SyntheticData.string.charAt(rnd.nextInt(SyntheticData.string.length())));
        }
        return sb.toString();
    }

    //generate random owners of a vehicle
    public List<OwnershipRecord> getOwners() {
        int noOfOwners = rnd.nextInt(3);
        VehicleDataUtilMethods dataUtil = new VehicleDataUtilMethods();
        List<LocalDate> dateList = new LinkedList<>();
        for (int j = 0; j < noOfOwners + 1; j++) {
            int day = 1;
            int month = 1 + rnd.nextInt(12);
            int year = 2016 + rnd.nextInt(8);
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                day = rnd.nextInt(31) + 1;
            } else if (month == 2) {
                day = 1 + rnd.nextInt(28);
            } else {
                day = 1 + rnd.nextInt(30);
            }
            LocalDate date = LocalDate.of(year, month, day);
            dateList.add(date);
        }
        Collections.sort(dateList);
        List<OwnershipRecord> list = new ArrayList<>();
        for (int j = 0; j <= noOfOwners; j++) {
            if (j == noOfOwners) {
                OwnershipRecord owner = new OwnershipRecord();
                owner.setOwnerAddress(dataUtil.getAddress());
                owner.setOwnerName(dataUtil.getFirstName() + " " + dataUtil.getLastName());
                owner.setPurchaseDate(dateList.get(j));
                owner.setSaleDate(null);
                owner.setOwnershipDuration(LocalDate.now().getYear() - owner.getPurchaseDate().getYear());
                list.add(owner);
            } else {
                OwnershipRecord owner = new OwnershipRecord();
                owner.setOwnerAddress(dataUtil.getAddress());
                owner.setOwnerName(dataUtil.getFirstName() + " " + dataUtil.getLastName());
                owner.setPurchaseDate(dateList.get(j));
                owner.setSaleDate(dateList.get(j + 1));
                owner.setOwnershipDuration(owner.getSaleDate().getYear() - owner.getPurchaseDate().getYear());
                list.add(owner);
            }
        }
        return list;
    }

    public int getYearOfVehicle(VehicleData vehilceModel) {
        List<OwnershipRecord> owners = vehilceModel.getOwnershipHistory();
        OwnershipRecord firstOwner = owners.get(0);
        LocalDate purchaseDate = firstOwner.getPurchaseDate();
        int fyear = purchaseDate.getYear();
        LocalDate date = LocalDate.now();
        return date.getYear() - fyear;
    }

    public LocalDate getRegDate(VehicleData vehicleData) {
        return vehicleData.getOwnershipHistory().get(0).getPurchaseDate();
    }

    public LocalDate manufacturingDateGenerator(VehicleData data) {
        LocalDate date = data.getOwnershipHistory().get(0).getPurchaseDate();
        int year = date.getYear() - 1;
        int day = Math.min(5, Math.abs(date.getDayOfMonth()));
        int month = Math.min(2, Math.abs(date.getDayOfMonth()));
        return LocalDate.of(year, month, day);
    }

    public DealerInformation dealerGenerator() {
        VehicleDataUtilMethods utilMethods = new VehicleDataUtilMethods();
        DealerInformation dealerInformation = new DealerInformation();
        dealerInformation.setDealerAddress(utilMethods.getAddress());
        dealerInformation.setDealerName(utilMethods.getFirstName() + " " + utilMethods.getLastName());
        dealerInformation.setGstNo(utilMethods.gstNoGenerator());
        return dealerInformation;
    }

    public WarrantyInformation warrantyInfoGenerator(VehicleData data) {
        LocalDate purchaseDate = data.getOwnershipHistory().get(0).getPurchaseDate();
        LocalDate warrantyEndDate;
        int day = purchaseDate.getDayOfMonth();
        int month = purchaseDate.getMonthValue();
        int year = rnd.nextInt(10) + 1 + purchaseDate.getYear();
        warrantyEndDate = LocalDate.of(year, month, day);
        WarrantyInformation warrantyInformation = new WarrantyInformation();
        warrantyInformation.setWarrantyStartDate(purchaseDate);
        warrantyInformation.setWarrantyEndDate(warrantyEndDate);
        if (warrantyEndDate.isAfter(LocalDate.now()) || warrantyEndDate.isEqual(LocalDate.now())) {
            warrantyInformation.setWarrantyStatus("In Warranty");
            warrantyInformation.setCoverage("All parts");
        } else {
            warrantyInformation.setWarrantyStatus("Out of Warranty");
            warrantyInformation.setCoverage("No parts");
        }
        return warrantyInformation;
    }

    public Double odometerReadingGenerator(VehicleData data) {
        double minOdometerReading = 10000.0;
        double maxOdometerReading = 1000000.0;
        LocalDate purchaseDate = data.getOwnershipHistory().get(0).getPurchaseDate();
        List<OwnershipRecord> ownersList = data.getOwnershipHistory();
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        String format = numberFormat.format(rnd.nextDouble(minOdometerReading + maxOdometerReading + ownersList.size() * purchaseDate.getYear()) + minOdometerReading);
        return Double.valueOf(format);

    }

    public Double priceGenerator(VehicleData data) {
        String brand = data.getBrand();
        double minPrice = 600000.0;
        double maxPrice = 8000000.0;
        if (brand.equals("Land Rover") || brand.equals("Porsche") || brand.equals("Lamborghini") || brand.equals("Ferrari") || brand.equals("Rolls-Royce") || brand.equals("Aston Martin")
                || brand.equals("Bentley") || brand.equals("Jeep") || brand.equals("Mercedes-Benz") || brand.equals("BMW") || brand.equals("Audi") || brand.equals("Jaguar")) {
            String str = rnd.nextInt(40) + 40 + "00000";
            DecimalFormat format = new DecimalFormat("#.00");
            String decimal = format.format(Double.valueOf(str));
            return Double.valueOf(decimal);
        } else if (brand.equals("Maruti Suzuki") || brand.equals("Fiat") || brand.equals("Honda") || brand.equals("Hyundai") || brand.equals("Mahindra") || brand.equals("MG")
                || brand.equals("Volvo") || brand.equals("Kia")) {
            String str = rnd.nextInt(10) + 15 + "00000";
            DecimalFormat format = new DecimalFormat("#.00");
            String decimal = format.format(Double.valueOf(str));
            return Double.valueOf(decimal);
        } else {
            String str = rnd.nextInt(15) + 5 + "00000";
            DecimalFormat format = new DecimalFormat("#.00");
            String decimal = format.format(Double.valueOf(str));
            return Double.valueOf(decimal);
        }


    }

    public String vehicleTypeGenerator() {
        return SyntheticData.vehilceType[rnd.nextInt(SyntheticData.vehilceType.length)];
    }

    public String vehicleTransmissionTypeGenerator() {
        return SyntheticData.trasmissionType[rnd.nextInt(SyntheticData.trasmissionType.length)];
    }

    public List<ServiceHistory> serviceHistoryGenerator(VehicleData data) {
        LocalDate purchaseDate = data.getOwnershipHistory().get(0).getPurchaseDate();
        int pYear = data.getOwnershipHistory().get(0).getPurchaseDate().getYear();
        int noOfServices = rnd.nextInt(4) + 1;
        List<ServiceHistory> list = new ArrayList<>();
        List<LocalDate> serviceDates = new ArrayList<>();
        if (pYear == LocalDate.now().getYear()) {
            return list;
        } else {
            for (int j = 0; j < 10; j++) {
                int day = 1;
                int month = 1 + rnd.nextInt(12);
                int sYear = pYear + rnd.nextInt(LocalDate.now().getYear() - pYear) + 1;

                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    day = rnd.nextInt(31) + 1;
                } else if (month == 2) {
                    day = 1 + rnd.nextInt(28);
                } else {
                    day = 1 + rnd.nextInt(30);
                }
                LocalDate date = LocalDate.of(sYear, month, day);
                if (date.isAfter(purchaseDate) && date.isBefore(LocalDate.now())) {
                    serviceDates.add(date);
                }
            }
            Collections.sort(serviceDates);
            for (int i = 0; i < serviceDates.size() && i < noOfServices; i++) {
                ServiceHistory serviceHistory = new ServiceHistory();
                serviceHistory.setServiceDate(serviceDates.get(i));
                serviceHistory.setServiceDescription(SyntheticData.serviceDescription[rnd.nextInt(SyntheticData.serviceDescription.length)]);
                list.add(serviceHistory);
            }
        }
        return list;
    }

    public String vehicleConditionGenerator(VehicleData data) {
        String response;
        int noOfOwners = data.getOwnershipHistory().size();
        switch (noOfOwners) {
            case 1: {
                response = "First hand";
                break;
            }
            case 2: {
                response = "Used";
                break;
            }
            default: {
                response = "Certified pre-owned";
                break;
            }
        }
        return response;
    }

    public List<String> fAndOGenerator(VehicleData data) {
        double price = data.getPrice();
        if (price <= 1000000.0) {
            int noOfFeatures = rnd.nextInt(2) + 1;
            Set<String> features = new HashSet<>();
            for (int i = 0; i < noOfFeatures; i++) {
                features.add(SyntheticData.featuresAndOptions[rnd.nextInt(SyntheticData.featuresAndOptions.length)]);
            }
            return features.stream().collect(Collectors.toList());
        } else if (price > 1000000.0 && price <= 2500000.0) {
            int noOfFeatures = rnd.nextInt(3) + 3;
            Set<String> features = new HashSet<>();
            for (int i = 0; i < noOfFeatures; i++) {
                features.add(SyntheticData.featuresAndOptions[rnd.nextInt(SyntheticData.featuresAndOptions.length)]);
            }
            return features.stream().collect(Collectors.toList());
        } else {
            int noOfFeatures = rnd.nextInt(3) + 6;
            Set<String> features = new HashSet<>();
            for (int i = 0; i < noOfFeatures; i++) {
                features.add(SyntheticData.featuresAndOptions[rnd.nextInt(SyntheticData.featuresAndOptions.length)]);
            }
            return features.stream().collect(Collectors.toList());
        }
    }
}
