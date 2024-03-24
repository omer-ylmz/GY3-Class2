package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Create.CreatedBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreatedBrandRequest createdBrandRequest);

    UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);

    List<GetBrandResponse> getAll();

    GetBrandResponse get(int id);
}
