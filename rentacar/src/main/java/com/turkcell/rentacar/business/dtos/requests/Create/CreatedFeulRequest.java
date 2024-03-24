package com.turkcell.rentacar.business.dtos.requests.Create;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatedFeulRequest {

    @NotNull
    @Size(min = 5,max = 30)
    private String name;
}
