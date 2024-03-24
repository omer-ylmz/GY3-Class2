package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedFeulRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateFuelResponse;
import com.turkcell.rentacar.entities.concretes.Fuel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelsController {

    private FuelService fuelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelResponse add(@Valid @RequestBody CreatedFeulRequest createdFeulRequest) {
        return fuelService.add(createdFeulRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateFuelResponse update(@RequestBody UpdateFuelRequest updateFuelRequest) {
        return fuelService.update(updateFuelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        fuelService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetFuelResponse get(@PathVariable int id) {
        return fuelService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetFuelResponse> getAll() {
        return fuelService.getAll();
    }
}
