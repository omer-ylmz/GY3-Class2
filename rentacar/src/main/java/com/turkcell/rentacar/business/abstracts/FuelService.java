package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Create.CreatedFeulRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateFuelResponse;
import com.turkcell.rentacar.entities.concretes.Fuel;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse add(CreatedFeulRequest createdFeulRequest);

    UpdateFuelResponse update(UpdateFuelRequest updateFuelRequest);

    void delete(int id);

    List<GetFuelResponse> getAll();

    GetFuelResponse get(int id);
}
