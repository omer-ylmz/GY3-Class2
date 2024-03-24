package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedFeulRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateFuelRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateFuelResponse;
import com.turkcell.rentacar.business.rules.FuelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    FuelRepository fuelRepository; // IoC
    ModelMapperService modelMapperService;
    FuelBusinessRules fuelBusinessRules;
    private static final String fuelNotFoundMessage = "Fuel not found";
    private static final String fuelAlreadyExistsMessage = "Fuel already exists";


    @Override
    public CreatedFuelResponse add(CreatedFeulRequest createdFeulRequest) {
        fuelBusinessRules.fuelNameCanNotBeDuplicated(createdFeulRequest.getName());

        Fuel fuel = this.modelMapperService.forRequest().map(createdFeulRequest,Fuel.class);

        fuel.setCreatedDate(LocalDateTime.now());

        Fuel createdFuel = fuelRepository.save(fuel);

        CreatedFuelResponse createdFuelResponse = this.modelMapperService.forResponse().map(createdFuel,CreatedFuelResponse.class);

        return createdFuelResponse;
    }

    @Override
    public UpdateFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        Fuel fuel = this.modelMapperService.forRequest().map(updateFuelRequest,Fuel.class);
        fuel.setUpdatedDate(LocalDateTime.now());

        Optional<Fuel> foundoptionalFuel = fuelRepository.findById(fuel.getId());
        fuelShouldBeExist(foundoptionalFuel);
        fuelNameCanNotBeDuplicatedWhenUpdated(fuel);

        Fuel fuelToUpdate = foundoptionalFuel.get();
        fuelToUpdate.setName(fuel.getName());
        UpdateFuelResponse updateFuelResponse = this.modelMapperService.forResponse().map(fuelToUpdate,UpdateFuelResponse.class);

        return updateFuelResponse;
    }



    @Override
    public void delete(int id) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findById(id);
        fuelShouldBeExist(foundOptionalFuel);
        fuelRepository.delete(foundOptionalFuel.get());
    }

    @Override
    public List<GetFuelResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<GetFuelResponse> fuelsResponse = new ArrayList<>();
        for(var fuel : fuels ){
            GetFuelResponse getFuelResponse = this.modelMapperService.forResponse().map(fuel,GetFuelResponse.class);
            fuelsResponse.add(getFuelResponse);
        }
        return fuelsResponse;
    }

    @Override
    public GetFuelResponse get(int id) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findById(id);
        fuelShouldBeExist(foundOptionalFuel);
        Fuel fuel  = foundOptionalFuel.get();
        GetFuelResponse getFuelResponse = this.modelMapperService.forResponse().map(fuel,GetFuelResponse.class);
        return getFuelResponse;
    }


    private void fuelShouldBeExist(Optional<Fuel> fuel) {
        if (fuel.isEmpty()) {
            throw new RuntimeException(fuelNotFoundMessage);
        }
    }

    private void fuelNameCanNotBeDuplicatedWhenUpdated(Fuel fuel) {
        boolean exists = fuelRepository.existsByNameIgnoreCaseAndIdIsNot(fuel.getName().trim(), fuel.getId());
        if (exists) {
            throw new RuntimeException(fuelAlreadyExistsMessage);
        }
    }
}
