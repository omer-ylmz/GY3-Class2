package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {

    private BrandService brandService;  //IoC

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreatedBrandRequest createBrandRequest){
        return brandService.add(createBrandRequest);
    }

    @PutMapping
    public UpdateBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest){
        return  brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponse get(@PathVariable int id) {
        return brandService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetBrandResponse> getAll() {
        return brandService.getAll();
    }

}
