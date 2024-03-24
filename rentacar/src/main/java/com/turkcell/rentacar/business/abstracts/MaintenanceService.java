package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Create.CreatedMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedMaintenanceResponse;



public interface MaintenanceService {
    CreatedMaintenanceResponse add(CreatedMaintenanceRequest createdMaintenanceRequest);
}
