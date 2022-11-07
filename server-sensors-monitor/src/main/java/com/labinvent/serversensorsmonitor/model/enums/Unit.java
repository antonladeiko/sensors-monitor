package com.labinvent.serversensorsmonitor.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum Unit {
    BAR("bar"),
    VOLTAGE("voltage"),
    CELSIUS("℃"),
    PERCENT("%");

    private String unit;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    private Unit(String unit){
        this.unit = unit;
    }
}
