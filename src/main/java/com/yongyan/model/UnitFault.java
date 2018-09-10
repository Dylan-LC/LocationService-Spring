package com.yongyan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;


/**
 * Created by yongyan on 09/09/2018
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@RequiredArgsConstructor
@Embeddable // Because in Location.java, field UnitFault is @Embedded
public class UnitFault {

    private final String vin;
    private Long spn;
    private Long fmi;

    @SuppressWarnings("unused")
    private UnitFault() {
        this.vin = "";
    }
}
