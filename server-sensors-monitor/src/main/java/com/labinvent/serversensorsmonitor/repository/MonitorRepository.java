package com.labinvent.serversensorsmonitor.repository;

import com.labinvent.serversensorsmonitor.model.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    Optional<Monitor> findById(Long id);

    Optional<Monitor> findByName(String name);
}
