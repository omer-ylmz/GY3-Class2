package com.turkcell.rentacar.business.dtos.responses.Create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatedFuelResponse {
    private int id;
    private LocalDateTime createdDate;
    private String name;
}
