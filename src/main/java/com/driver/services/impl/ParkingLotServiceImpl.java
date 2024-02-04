package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(name);
        parkingLot.setAddress(address);

        parkingLotRepository1.save(parkingLot);
        return parkingLot;
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {

            Spot spot = new Spot();
            spot.setPricePerHour(pricePerHour);
            if(numberOfWheels==2){
                spot.setSpotType(SpotType.TWO_WHEELER);
            }
            else if(numberOfWheels==4){
                spot.setSpotType(SpotType.FOUR_WHEELER);
            }
            else{
                spot.setSpotType(SpotType.OTHERS);
            }
            ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
            spot.setParkingLot(parkingLot);

            List<Spot> spotList = new ArrayList<>();
            spotList.add(spot);
            parkingLot.setSpotList(spotList);
            parkingLotRepository1.save(parkingLot);

            return spot;

    }

    @Override
    public void deleteSpot(int spotId) {

        Spot spot = spotRepository1.findById(spotId).get();

        ParkingLot parkingLot = spot.getParkingLot();

        parkingLot.getSpotList().remove(spot);

        spotRepository1.deleteById(spotId);

    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {

        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
        if(parkingLot != null){
            Spot spot = spotRepository1.findById(spotId).get();
            spot.setPricePerHour(pricePerHour);

            spotRepository1.save(spot);
            return spot;
        }
        else {
            return null;
        }

//        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
//
//        parkingLot
//        List<Spot> spotList = new ArrayList<>();
//        spotList.add(spot);
//        parkingLot.setSpotList(spotList);
//        parkingLotRepository1.save(parkingLot);
//
//        return spot;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        //        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
        parkingLotRepository1.deleteById(parkingLotId);
    }


}
