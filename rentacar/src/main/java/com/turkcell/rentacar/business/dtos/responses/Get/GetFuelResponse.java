package com.turkcell.rentacar.business.dtos.responses.Get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class GetFuelResponse {
    private int Id;

    private LocalDateTime createdDate;

    private String name;

}
