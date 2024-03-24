package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedModelRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateFuelResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateModelResponse;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
  ModelRepository modelRepository;
  ModelMapperService modelMapperService;
  ModelBusinessRules modelBusinessRules;
    private static final String modelNotFoundMessage = "Model not found";


    @Override
    public CreatedModelResponse add(CreatedModelRequest createdModelRequest) {

        modelBusinessRules.modelNameCanNotBeDuplicated(createdModelRequest.getName());

        Model model = this.modelMapperService.forRequest().map(createdModelRequest,Model.class);

        model.setCreatedDate(LocalDateTime.now());

        Model createdModel = modelRepository.save(model);

        CreatedModelResponse createdModelResponse = this.modelMapperService.forResponse().map(createdModel,CreatedModelResponse.class);

        return createdModelResponse;
    }

    @Override
    public UpdateModelResponse update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest,Model.class);
        model.setUpdatedDate(LocalDateTime.now());

        Optional<Model> foundoptionalModel = modelRepository.findById(model.getId());
        modelShouldBeExist(foundoptionalModel);


        Model modelToUpdate = foundoptionalModel.get();
        modelToUpdate.setName(model.getName());
        UpdateModelResponse updateModelResponseResponse = this.modelMapperService.forResponse().map(modelToUpdate,UpdateModelResponse.class);

        return updateModelResponseResponse;
    }


    @Override
    public void delete(int id) {
        Optional<Model> foundOptionalModel = modelRepository.findById(id);
        modelShouldBeExist(foundOptionalModel);
        modelRepository.delete(foundOptionalModel.get());
    }

    @Override
    public List<GetModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetModelResponse> modelsResponse = new ArrayList<>();
        for(var model : models ){
            GetModelResponse getModelResponse = this.modelMapperService.forResponse().map(model,GetModelResponse.class);
            modelsResponse.add(getModelResponse);
        }
        return modelsResponse;
    }

    @Override
    public GetModelResponse get(int id) {
        Optional<Model> foundOptionalModel = modelRepository.findById(id);
        modelShouldBeExist(foundOptionalModel);
        Model model  = foundOptionalModel.get();
        GetModelResponse getModelResponse = this.modelMapperService.forResponse().map(model,GetModelResponse.class);
        return getModelResponse;
    }


    private void modelShouldBeExist(Optional<Model> model) {
        if (model.isEmpty()) {
            throw new RuntimeException(modelNotFoundMessage);
        }
    }


}
