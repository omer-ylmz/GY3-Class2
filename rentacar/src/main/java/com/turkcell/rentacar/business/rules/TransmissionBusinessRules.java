package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TransmissionBusinessRules {
    TransmissionRepository transmissionRepository;

    public void transmissionNameCanNotBeDuplicated(String transmissionName){

        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(transmissionName);
        if(transmission.isPresent()){
            throw new BusinessException("Transmissions Exists");
        }


    }
}
