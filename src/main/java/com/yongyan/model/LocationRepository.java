package com.yongyan.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * created by yongyan on 09/10/2018
 * combine database api with re-properties we build to satisfy the requirements of controller. middle well do generate final correct data to controller.
 */

public interface LocationRepository extends JpaRepository<Location, Long> { // support what operations controller needs

    Page<Location> findByVehicleMovementType(@Param("movementType") Location.VehicleMovementType movementType, Pageable pageable);
    Page<Location> findByUnitInfoUnitVin(@Param("unitVin") String unitVin, Pageable pageable); // pageable para defines how to Page the output

}
