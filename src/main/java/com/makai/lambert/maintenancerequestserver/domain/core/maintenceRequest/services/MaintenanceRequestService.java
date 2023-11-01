package com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.services;


import com.makai.lambert.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.makai.lambert.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.models.MaintenanceRequest;

import java.util.List;

public interface MaintenanceRequestService {


    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;

    MaintenanceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException;

    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;

    MaintenanceRequest getByFirstName(String firstName) throws ResourceNotFoundException;

    MaintenanceRequest getByLastName(String lastName) throws ResourceNotFoundException;

    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;

    List<MaintenanceRequest> getAll();

    MaintenanceRequest update(Long id, MaintenanceRequest description) throws ResourceNotFoundException;

    void delete(Long id);
}
