package com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.repos;

import com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.models.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface MaintenanceRequestRepo extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByEmail(String email);

    Optional<MaintenanceRequest> findByAptNumber(String aptNumber);

    Optional<MaintenanceRequest> findByFirstName(String firstName);

    Optional<MaintenanceRequest> findByLastName(String lastName);



}
