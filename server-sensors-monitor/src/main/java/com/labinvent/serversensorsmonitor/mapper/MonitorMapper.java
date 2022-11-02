package com.labinvent.serversensorsmonitor.mapper;

import com.labinvent.serversensorsmonitor.dto.MonitorDto;
import com.labinvent.serversensorsmonitor.model.Monitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonitorMapper {

    MonitorDto monitorToMonitorDto(Monitor monitor);

    Monitor monitorDtoToMonitor(MonitorDto monitorDto);
}
