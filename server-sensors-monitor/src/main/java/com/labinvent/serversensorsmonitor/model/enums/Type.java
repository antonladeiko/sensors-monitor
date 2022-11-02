package com.labinvent.serversensorsmonitor.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Type {
    PRESSURE("Pressure"),
    VOLTAGE("VOLTAGE"),
    TEMPERATURE("Temperature"),
    HUMIDITY("Humidity");

    private final String type;
}
