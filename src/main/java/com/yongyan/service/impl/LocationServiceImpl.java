package com.yongyan.service.impl;

import com.yongyan.model.Location;
import com.yongyan.model.LocationRepository;
import com.yongyan.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yongyan on 09/10/2018
 */

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;
    // 因为我们想用LocationRepository，所以我们固然有一种方法可以直接new LocationRepository(): private LocationRepository locationRepository = new LocationRepository()
    // 但这样做的的缺点是，等于用LocationServiceImpl class控制了LocationRepository class，其实我们想要在这里implement IoC and DI

    @Autowired // declare locationRepository is a bean
    public LocationServiceImpl(LocationRepository locationRepository) { // bean's scope is singleton, which means all services in the project use the same LocationRepository
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> saveCarLocation(List<Location> carLocations) {
        return locationRepository.save(carLocations); // save method should be defined in LocationRepository class which extends JpaRepository class
    }

    @Override
    public void deleteAll() { // void doesn't need a return val
        locationRepository.deleteAll();
    }

    @Override
    public Page<Location> findByMovementType(String movementType, Pageable pageable) {
        // transfer the input movementType to enum type data
        return locationRepository.findByVehicleMovementType(Location.VehicleMovementType.valueOf(movementType), pageable);
    }

    @Override
    public Page<Location> findByVin(String vin, Pageable pageable) {
        return locationRepository.findByUnitInfoUnitVin(vin, pageable);
    }
}
