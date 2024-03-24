package com.turkcell.rentacar.business.dtos.requests.Create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCarRequest {
    private int modelYear;

    private String plate;

    private double dailyPrice;

    private int modelId;

}
