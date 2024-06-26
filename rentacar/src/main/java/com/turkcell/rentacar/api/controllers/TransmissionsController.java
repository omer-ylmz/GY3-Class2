package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {
    private TransmissionService transmissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse add(@Valid @RequestBody CreatedTransmissionRequest createdTransmissionRequest) {
        return transmissionService.add(createdTransmissionRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateTransmissionResponse update(@RequestBody UpdateTransmissionRequest updateTransmissionRequest) {
        return transmissionService.update(updateTransmissionRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        transmissionService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetTransmissionResponse get(@PathVariable int id) {
        return transmissionService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetTransmissionResponse> getAll() {
        return transmissionService.getAll();
    }
}
