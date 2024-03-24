package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Create.CreatedTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;

import java.util.List;

public interface TransmissionService {

    CreatedTransmissionResponse add(CreatedTransmissionRequest createdTransmissionRequest);

    UpdateTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest);

    void delete(int id);

    List<GetTransmissionResponse> getAll();

    GetTransmissionResponse get(int id);
}
