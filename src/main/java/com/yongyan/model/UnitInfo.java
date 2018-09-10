package com.yongyan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by yongyan on 09/09/2018
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UnitInfo {

    private final String unitVin; // For a car, once assigned, its vin cannot be changed. Therefore, we use 'final'.
    private String engineMake;
    private String registerName;
    private String unitName;

    @SuppressWarnings("unused")
    private UnitInfo() { // This constructor is built just for solving the error of final above temporarily.
        this.unitVin = "";
    }
}
