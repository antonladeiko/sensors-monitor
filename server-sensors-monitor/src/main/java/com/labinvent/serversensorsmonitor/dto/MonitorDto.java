package com.labinvent.serversensorsmonitor.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.labinvent.serversensorsmonitor.model.enums.Type;
import com.labinvent.serversensorsmonitor.model.enums.Unit;
import lombok.Data;


@Data
public class MonitorDto {
    @JsonIgnore
    private Long id;

    private String name;

    private String model;

    private int rangeFrom;

    private int rangeTo;

    private Type type;

    private Unit unit;

    private String location;

    private String description;
}
