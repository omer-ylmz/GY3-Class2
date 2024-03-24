package com.turkcell.rentacar.business.dtos.responses.Create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedModelResponse {

    private int Id;

    private String name;

    private LocalDateTime createdDate;


}
