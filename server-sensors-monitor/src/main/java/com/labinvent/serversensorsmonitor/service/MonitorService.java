package com.labinvent.serversensorsmonitor.service;

import com.labinvent.serversensorsmonitor.dto.MonitorDto;

import java.util.List;

public interface MonitorService {
    MonitorDto name(String name);
    MonitorDto create(MonitorDto monitorDto);
    List<MonitorDto> list();
    MonitorDto get(Long id);
    MonitorDto update(MonitorDto monitorDto);
    Boolean delete(Long id);
}
