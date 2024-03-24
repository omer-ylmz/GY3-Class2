package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateTransmissionResponse;
import com.turkcell.rentacar.business.rules.TransmissionBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    TransmissionRepository transmissionRepository; // IoC
    ModelMapperService modelMapperService;
    TransmissionBusinessRules transmissionBusinessRules;
    private static final String transmissionNotFoundMessage = "Transmission not found";



    @Override

    public CreatedTransmissionResponse add(CreatedTransmissionRequest createdTransmissionRequest) {
        transmissionBusinessRules.transmissionNameCanNotBeDuplicated(createdTransmissionRequest.getName());

        Transmission transmission = this.modelMapperService.forRequest().map(createdTransmissionRequest,Transmission.class);

        transmission.setCreatedDate(LocalDateTime.now());

        Transmission createdTransmission = transmissionRepository.save(transmission);

        CreatedTransmissionResponse createdTransmissionResponse = this.modelMapperService.forResponse().map(createdTransmission,CreatedTransmissionResponse.class);

        return createdTransmissionResponse;
    }

    @Override
    public UpdateTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        Transmission transmission = this.modelMapperService.forRequest().map(updateTransmissionRequest,Transmission.class);
        transmission.setUpdatedDate(LocalDateTime.now());

        Optional<Transmission> foundoptionalTransmission = transmissionRepository.findById(transmission.getId());
        transmissionShouldBeExist(foundoptionalTransmission);


        Transmission transmissionToUpdate = foundoptionalTransmission.get();
        transmissionToUpdate.setName(transmission.getName());
        UpdateTransmissionResponse updateTransmissionResponse = this.modelMapperService.forResponse().map(transmissionToUpdate,UpdateTransmissionResponse.class);

        return updateTransmissionResponse;
    }


    @Override
    public void delete(int id) {
        Optional<Transmission> foundOptionalTransmission = transmissionRepository.findById(id);
        transmissionShouldBeExist(foundOptionalTransmission);
        transmissionRepository.delete(foundOptionalTransmission.get());
    }

    @Override
    public List<GetTransmissionResponse> getAll() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        List<GetTransmissionResponse> transmissionsResponse = new ArrayList<>();
        for(var transmission : transmissions){
            GetTransmissionResponse getTransmissionResponse = this.modelMapperService.forResponse().map(transmission,GetTransmissionResponse.class);
            transmissionsResponse.add(getTransmissionResponse);
        }
        return transmissionsResponse;
    }

    @Override
    public GetTransmissionResponse get(int id) {
        Optional<Transmission> foundOptionalTransmission = transmissionRepository.findById(id);
        transmissionShouldBeExist(foundOptionalTransmission);
        Transmission transmission  = foundOptionalTransmission.get();
        GetTransmissionResponse getTransmissionResponse = this.modelMapperService.forResponse().map(transmission,GetTransmissionResponse.class);
        return getTransmissionResponse;
    }


    // temp business rules
    // TODO: TransmissionBusinessRules
    private void transmissionShouldBeExist(Optional<Transmission> transmission) {
        if (transmission.isEmpty()) {
            throw new RuntimeException(transmissionNotFoundMessage);
        }
    }


    private void transmissionNameCanNotBeDuplicatedWhenUpdated(Transmission transmission) {
        boolean exists = transmissionRepository.existsByNameIgnoreCaseAndIdIsNot(transmission.getName().trim(), transmission.getId());
        if (exists) {
            throw new RuntimeException(transmissionNotFoundMessage);
        }
    }
}
