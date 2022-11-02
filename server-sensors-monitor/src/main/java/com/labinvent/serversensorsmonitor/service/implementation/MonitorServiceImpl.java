package com.labinvent.serversensorsmonitor.service.implementation;

import com.labinvent.serversensorsmonitor.dto.MonitorDto;
import com.labinvent.serversensorsmonitor.exceptions.NotFoundException;
import com.labinvent.serversensorsmonitor.mapper.MonitorMapper;
import com.labinvent.serversensorsmonitor.model.Monitor;
import com.labinvent.serversensorsmonitor.repository.MonitorRepository;
import com.labinvent.serversensorsmonitor.service.MonitorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class MonitorServiceImpl implements MonitorService {

    private final MonitorRepository monitorRepository;
    private final MonitorMapper monitorMapper;

    @Override
    public MonitorDto name(String name) {
        log.info("Fetching a monitor by name: {}", name);
        Monitor monitor = monitorRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Monitor with name: " + name + " not found"));
        log.info("Received  monitor: {}", monitor);

        return monitorMapper.monitorToMonitorDto(monitor);
    }

    @Override
    public MonitorDto create(MonitorDto monitorDto) {
        Monitor monitor = monitorMapper.monitorDtoToMonitor(monitorDto);
        monitorRepository.save(monitor);
        log.info("Saving Monitor: {}", monitor);
        return monitorMapper.monitorToMonitorDto(monitor);
    }

    @Override
    public List<MonitorDto> list() {
        List<Monitor> monitorList = monitorRepository.findAll();
        log.info("Received list monitors: {}", monitorList);

        return monitorList.stream()
                .filter(Objects::nonNull)
                .map(monitorMapper::monitorToMonitorDto)
                .collect(Collectors.toList());
    }

    @Override
    public MonitorDto get(Long id) {
        log.info("Fetching a monitor by id: {}", id);
        Monitor monitor = monitorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Monitor with id: " + id + " not found"));
        log.info("Received monitor: {}", monitor);

        return monitorMapper.monitorToMonitorDto(monitor);
    }

    @Override
    public MonitorDto update(MonitorDto monitorDto) {
        Monitor monitor = monitorMapper.monitorDtoToMonitor(monitorDto);
        monitorRepository.save(monitor);
        log.info("Saved updated monitor: {}", monitor);

        return monitorMapper.monitorToMonitorDto(monitor);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting monitor by id: {}", id);
        monitorRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
