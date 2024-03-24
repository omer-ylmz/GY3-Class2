package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Create.CreatedModelRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateModelResponse;
import com.turkcell.rentacar.entities.concretes.Model;

import java.util.List;

public interface ModelService {
    CreatedModelResponse add(CreatedModelRequest createdModelRequest);

    UpdateModelResponse update(UpdateModelRequest updateModelRequest);

    void delete(int id);

    List<GetModelResponse> getAll();

    GetModelResponse get(int id);
}
