package com.makai.lambert.maintenancerequestserver;

import com.makai.lambert.maintenancerequestserver.domain.core.maintenceRequest.models.MaintenanceRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaintenanceRequestTest {


    @Test
    public void constructorTest01() {
        Date date = new Date();
       MaintenanceRequest maintenanceRequest = new MaintenanceRequest("Makai", "Lambert", "makai.lambert@gmail.com", "APT9", "broken sink", "2023-10-11");

       maintenanceRequest.setId(1L);
       String actual = maintenanceRequest.toString();
       String expected = "1 Makai Lambert makai.lambert@gmail.com APT9 broken sink 2023-10-11";

       assertEquals(actual, expected);
    }
}
