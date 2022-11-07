package com.labinvent.serversensorsmonitor.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum Type {
    PRESSURE("Pressure"),
    VOLTAGE("Voltage"),
    TEMPERATURE("Temperature"),
    HUMIDITY("Humidity");

    private String type;
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    private Type(String type){
        this.type = type;
    }
}
