package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedModelRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateModelResponse;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {
    private ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@Valid @RequestBody CreatedModelRequest createdModelRequest) {
        return modelService.add(createdModelRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateModelResponse update(@RequestBody UpdateModelRequest updateModelRequest) {
        return modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        modelService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetModelResponse get(@PathVariable int id) {
        return modelService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetModelResponse> getAll() {
        return modelService.getAll();
    }
}
