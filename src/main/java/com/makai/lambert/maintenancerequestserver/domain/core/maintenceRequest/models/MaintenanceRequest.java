package com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String aptNumber;

    @NonNull
    private String description;

    @NonNull
    private String createdAt;

    public String toString() {return String.format("%d %s %s %s %s %s %tF", id, firstName, lastName, email, aptNumber, description, createdAt); }



}
