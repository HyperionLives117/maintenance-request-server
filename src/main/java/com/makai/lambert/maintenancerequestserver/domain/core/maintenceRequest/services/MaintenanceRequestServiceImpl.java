package com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.services;


import com.makai.lambert.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.makai.lambert.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.models.MaintenanceRequest;
import com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.repos.MaintenanceRequestRepo;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService{

    private MaintenanceRequestRepo maintenanceRequestRepo;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo){
        this.maintenanceRequestRepo = maintenanceRequestRepo;
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
        if(optional.isPresent()) {
            throw new ResourceCreationException("Maintenance request with email exists" + maintenanceRequest.getEmail());
        }
        return maintenanceRequestRepo.save(maintenanceRequest);
    }

    @Override
    public MaintenanceRequest getByAptNumber(String aptNumber) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByAptNumber(aptNumber)
                .orElseThrow(() -> new ResourceNotFoundException("No request with this apartment number exists: " + aptNumber));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("No maintenance request with email exists: " + email));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByFirstName(String firstName) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByFirstName(firstName)
                .orElseThrow(() -> new ResourceNotFoundException("No maintenance request under first name exists: " + firstName));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByLastName(String lastName) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByLastName(lastName)
                .orElseThrow(() -> new ResourceNotFoundException("No maintenance request under last name exists: " + lastName));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No request with id:" + id));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepo.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest requestDetail) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(requestDetail.getFirstName());
        maintenanceRequest.setLastName(requestDetail.getLastName());
        maintenanceRequest.setEmail(requestDetail.getEmail());
        maintenanceRequest.setDescription(requestDetail.getDescription());
        maintenanceRequest.setCreatedAt(requestDetail.getCreatedAt());
        maintenanceRequest.setAptNumber(requestDetail.getAptNumber());
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequestRepo.delete(maintenanceRequest);
    }


}
