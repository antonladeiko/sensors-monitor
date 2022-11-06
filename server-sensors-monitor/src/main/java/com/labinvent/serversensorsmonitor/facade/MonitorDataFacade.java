package com.labinvent.serversensorsmonitor.facade;

import com.labinvent.serversensorsmonitor.dto.MonitorDto;
import com.labinvent.serversensorsmonitor.mapper.MonitorMapper;
import com.labinvent.serversensorsmonitor.model.Monitor;
import com.labinvent.serversensorsmonitor.service.MonitorService;
import com.labinvent.serversensorsmonitor.web.response.MonitorResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@Component
@AllArgsConstructor
public class MonitorDataFacade {
    private final MonitorService monitorService;
    private final MonitorMapper monitorMapper;


    public MonitorResponse createMonitor(Monitor monitor){
        log.info("Got create monitor request: {}", monitor);
        MonitorDto monitorDto = monitorMapper.monitorToMonitorDto(monitor);

        return MonitorResponse.builder()
                .time(now())
                .data(Map.of("monitor", monitorService.create(monitorDto)))
                .status(CREATED)
                .statusCode(CREATED.value())
                .message("Monitor saved")
                .build();
    }

    public MonitorResponse getList(){
        log.info("Got list of monitors request");

        List<MonitorDto> monitors = monitorService.list();
        log.info("List: {}", monitors);

        return MonitorResponse.builder()
                .time(now())
                .data(Map.of("monitors", monitorService.list()))
                .status(OK)
                .statusCode(OK.value())
                .message("List of monitors received")
                .build();
    }

    public MonitorResponse getMonitorById(Long id){
        log.info("Got monitor request by id: {}", id);

        log.info("monitor: {}", monitorService.get(id));

        return MonitorResponse.builder()
                .time(now())
                .data(Map.of("monitor", monitorService.get(id)))
                .status(OK)
                .statusCode(OK.value())
                .message("Monitor received by id")
                .build();
    }

    public MonitorResponse getMonitorByName(String name){
        log.info("Got monitor request by name: {}", name);

        return MonitorResponse.builder()
                .time(now())
                .data(Map.of("monitor", monitorService.name(name)))
                .status(OK)
                .statusCode(OK.value())
                .message("Monitor received by name")
                .build();
    }

    public MonitorResponse updateMonitor(Monitor monitor){
        log.info("Got update monitor request: {}", monitor);
        MonitorDto monitorDto = monitorMapper.monitorToMonitorDto(monitor);

        return MonitorResponse.builder()
                .time(now())
                .data(Map.of("monitor", monitorService.update(monitorDto)))
                .status(OK)
                .statusCode(OK.value())
                .message("Monitor data updated")
                .build();
    }

    public MonitorResponse deleteMonitor(Long id){
        log.info("Got delete monitor request by id: {}", id);

        return MonitorResponse.builder()
                .time(now())
                .data(Map.of("removed monitor", monitorService.delete(id)))
                .status(OK)
                .statusCode(OK.value())
                .message("Monitor was deleted")
                .build();
    }


}
