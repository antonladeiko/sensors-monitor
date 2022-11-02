package com.labinvent.serversensorsmonitor.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Unit {
    BAR("bar"),
    VOLTAGE("VOLTAGE"),
    CELSIUS("℃"),
    PERCENT("%");

    private final String unit;
}
