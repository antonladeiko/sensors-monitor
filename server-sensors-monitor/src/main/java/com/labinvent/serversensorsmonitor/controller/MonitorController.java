package com.labinvent.serversensorsmonitor.controller;

import com.labinvent.serversensorsmonitor.facade.MonitorDataFacade;
import com.labinvent.serversensorsmonitor.model.Monitor;
import com.labinvent.serversensorsmonitor.web.constant.WebConstant;
import com.labinvent.serversensorsmonitor.web.response.MonitorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = WebConstant.VERSION_URL + "/monitors",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MonitorController {
    private final MonitorDataFacade monitorDataFacade;

    @GetMapping()
    public MonitorResponse getMonitors(){
        MonitorResponse response = monitorDataFacade.getList();
        log.info("Response with get list of monitors: {}", response);
        return response;
    }

    @PostMapping("/create")
    public MonitorResponse createMonitor(@RequestBody @Valid Monitor monitor){
        MonitorResponse response = monitorDataFacade.createMonitor(monitor);
        log.info("Response with create monitor: {}", response);
        return response;
    }

    @PutMapping("/update")
    public MonitorResponse updateMonitor(@RequestBody @Valid Monitor monitor){
        MonitorResponse response = monitorDataFacade.updateMonitor(monitor);
        log.info("Response with update monitor: {}", response);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public MonitorResponse deleteMonitor(@PathVariable Long id){
        MonitorResponse response = monitorDataFacade.deleteMonitor(id);
        log.info("Response with delete monitor: {}", response);
        return response;
    }
}
