package com.labinvent.serversensorsmonitor.mapper;

import com.labinvent.serversensorsmonitor.dto.MonitorDto;
import com.labinvent.serversensorsmonitor.model.entity.Monitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MonitorMapper {
    //@Mapping(target = "id", ignore = true)
    MonitorDto monitorToMonitorDto(Monitor monitor);

    //@Mapping(target = "id", ignore = true)
    Monitor monitorDtoToMonitor(MonitorDto monitorDto);
}
