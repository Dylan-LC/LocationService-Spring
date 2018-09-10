package com.yongyan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yongyan on 09/09/2018
 */

// if we copy annotations, we need to put cursor on the annotation and 'command + return'(Mac) / 'Alt + Enter'(Windows)
@JsonInclude(JsonInclude.Include.NON_NULL) // deal with null value. For example, if address's val is null, there will be no key 'address' in the json file finally
@RequiredArgsConstructor // from lombok, it creates constructor automatically
@Data // create get & set for fields
@Entity // create property in h2database automatically for relevant filed.
@Table(name = "LOCATION") // find the table in local class
public class Location {

    enum GpsStatus { // Since no other places need this GpsStatus, we can put this class under class Location.
        EXCELLENT, OK, UNRELIABLE, BAD, NOFIX, UNKNOWN;
    }

    public enum VehicleMovementType { //enum type is able to has methods
        STOPPED, IN_MOTION;

        public boolean isMoving() {
            return this != STOPPED;
        }
    }

    @Id // unique
    @GeneratedValue // id automatically generated
    private Long id; // unique, automatically generated

    @Embedded // declare unitInfo is a class
    @AttributeOverride(name = "engineMake", column = @Column(name = "unit_engine_make")) //when the name of field in class is different from the name in database, how could we override
    private final UnitInfo unitInfo;

    @Embedded
    @AttributeOverrides({ // override multiple fields in class
            @AttributeOverride(name = "fmi", column = @Column(name = "unit_fmi")),
            @AttributeOverride(name = "spn", column = @Column(name = "unit_spn"))})
    private UnitFault unitFault;

    private double latitude;
    private double longitude;
    private String heading;
    private double gpsSpeed;
    private GpsStatus gpsStatus; // the status of gps is limited and there is a fixed name for each status. Enum Types
    private double odometer;
    private double totalEngineTime;
    private double totalIdleTime;
    private double totalFuelUsage;
    private String address;
    private Date timestamp = new Date();
    private String tspProvider;
    private VehicleMovementType vehicleMovementType = VehicleMovementType.STOPPED; // there is only 2 kinds of status.
    private String serviceType;

    @Embedded
    private FaultCode faultCode;

    @SuppressWarnings("unused") //tell the reader, this constructor is useless, just for "final UnitInfo unitInfo".
    private Location() {
        this.unitInfo = null;
    }


}
