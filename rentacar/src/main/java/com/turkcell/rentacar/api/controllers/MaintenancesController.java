package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedMaintenanceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/maintenances")
public class MaintenancesController {
    private MaintenanceService maintenanceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedMaintenanceResponse add(@Valid @RequestBody CreatedMaintenanceRequest createMaintenanceRequest){
        return maintenanceService.add(createMaintenanceRequest);
    }

}
