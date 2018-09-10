package com.yongyan.controller;

import com.yongyan.model.Location;
import com.yongyan.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by yongyan on 09/10/2018
 * RESTful API: create, read, update, delete
 * for Location.java, create & update can be seen as a same thing: upload
 * read by vin, movement-type
 */

@RestController
public class LocationServiceRestController {

    private LocationService locationService;

    @Autowired
    public LocationServiceRestController(LocationService locationService){
        this.locationService = locationService;
    }

    @RequestMapping(value = "/fleet", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //manually change the status of http, which can cheat your browser
    public void upload(@RequestBody List<Location> locations) { // @RequestBody tells program where to find locations
        // save to database
        this.locationService.saveCarLocations(locations);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete() {
        this.locationService.deleteAll();
    }

    @RequestMapping(value = "/fleet/{movementType}", method = RequestMethod.GET)
    public Page<Location> findByMovementType(@PathVariable String movementType, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return this.locationService.findByMovementType(movementType, new PageRequest(page, size));
    }

    @RequestMapping(value = "/fleet/vin/{vin}", method = RequestMethod.GET)
    public Page<Location> findByVinNumber(@PathVariable String vin, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return this.locationService.findByVin(vin, new PageRequest(page, size));
    }

}
