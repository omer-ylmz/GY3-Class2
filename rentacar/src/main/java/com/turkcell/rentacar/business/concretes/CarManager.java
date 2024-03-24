package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedCarRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedCarResponse;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;


    @Override
    public CreatedCarResponse add(CreatedCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);

        car.setCreatedDate(LocalDateTime.now());

        car.setState(1); //boşta

        Car createdCar = carRepository.save(car);

        CreatedCarResponse createdCarResponse = this.modelMapperService.forResponse().map(createdCar,CreatedCarResponse.class);

        return createdCarResponse;
    }
}
