package com.yongyan.service;

import com.yongyan.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * created by yongyan on 09/10/2018
 */

public interface LocationService {
    List<Location> saveCarLocations(List<Location> carLocations);

    void deleteAll();

    Page<Location> findByMovementType(String movementType, Pageable pageable);

    Page<Location> findByVin(String vin, Pageable pageable);
}
