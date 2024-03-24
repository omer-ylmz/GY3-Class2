package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Create.CreatedCarRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedCarResponse;

public interface CarService {
    CreatedCarResponse add(CreatedCarRequest createCarRequest);
}
