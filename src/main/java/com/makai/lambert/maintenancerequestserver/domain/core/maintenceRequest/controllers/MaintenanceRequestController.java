package com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.controllers;

import com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.models.MaintenanceRequest;
import com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.services.MaintenanceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/requests")
@CrossOrigin("*")
public class MaintenanceRequestController {

    private MaintenanceRequestService maintenanceRequestService;

    @Autowired
    public MaintenanceRequestController(MaintenanceRequestService maintenanceRequestService) {
        this.maintenanceRequestService = maintenanceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceRequest>> getAll() {
        List<MaintenanceRequest> maintenanceRequests = maintenanceRequestService.getAll();
        return new ResponseEntity<>(maintenanceRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MaintenanceRequest> create(@RequestBody MaintenanceRequest maintenanceRequest) {
        maintenanceRequest = maintenanceRequestService.create(maintenanceRequest);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintenanceRequest> getById(@PathVariable("id")Long id) {
        MaintenanceRequest maintenanceRequest = maintenanceRequestService.getById(id);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<MaintenanceRequest> getByEmail(@RequestParam String email) {
        MaintenanceRequest maintenanceRequest = maintenanceRequestService.getByEmail(email);
        return new ResponseEntity<>(maintenanceRequest, HttpStatus.OK);
    }



    @PutMapping("{id}")
    public ResponseEntity<MaintenanceRequest> update(@PathVariable("id") Long id, @RequestBody MaintenanceRequest requestDetail) {
        requestDetail = maintenanceRequestService.update(id, requestDetail);
        return new ResponseEntity<>(requestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        maintenanceRequestService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
