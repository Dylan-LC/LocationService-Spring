package com.yongyan.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;

/**
 * Created by yongyan on 09/09/2018
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@RequiredArgsConstructor
public class FaultCode {
    private String engineMake;
    private String faultCode;
    private String faultCodeId;
    private String faultCodeClassification;
    private String description;
    @Column(length=1024) // limit the length of repairInstructions
    private String repairInstructions;
    private Long fmi;
    private String sa;
    private Long spn;
}
