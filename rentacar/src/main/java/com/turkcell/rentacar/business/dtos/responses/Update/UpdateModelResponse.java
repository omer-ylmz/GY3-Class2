package com.turkcell.rentacar.business.dtos.responses.Update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateModelResponse {
    private int id;
    private String name;
    private LocalDateTime updateTime;
}
