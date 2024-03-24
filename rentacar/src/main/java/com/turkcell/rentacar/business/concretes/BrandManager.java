package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.Create.CreatedBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.Update.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.Create.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Get.GetBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.Update.UpdateBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
    private static final String brandNotFound = "Brand not found";
    private static final String brandAlreadyExists = "Brand already exists";

    //AOP

    @Override
    public CreatedBrandResponse add(CreatedBrandRequest createBrandRequest) {

        brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand =  brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse = this.modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);

        return createdBrandResponse;
    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        brand.setUpdatedDate(LocalDateTime.now());

        Optional<Brand> foundoptionalBrand = brandRepository.findById(brand.getId());
        brandShouldBeExist(foundoptionalBrand);
        brandNameCanNotBeDuplicatedWhenUpdated(brand);

        Brand brandToUpdate = foundoptionalBrand.get();
        brandToUpdate.setName(brand.getName());
        UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(brandToUpdate,UpdateBrandResponse.class);

        return updateBrandResponse;

    }


    @Override
    public void delete(int id) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(id);
        brandShouldBeExist(foundOptionalBrand);
        brandRepository.delete(foundOptionalBrand.get());
    }

    @Override
    public List<GetBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandResponse> brandsResponse = new ArrayList<>();
        for(var brand : brands ){
            GetBrandResponse getBrandResponse = this.modelMapperService.forResponse().map(brand,GetBrandResponse.class);
            brandsResponse.add(getBrandResponse);
        }
        return brandsResponse;

    }

    @Override
    public GetBrandResponse get(int id) {
        Optional<Brand> foundOptionalBrand = brandRepository.findById(id);
        brandShouldBeExist(foundOptionalBrand);
        Brand brand = foundOptionalBrand.get();
        GetBrandResponse getBrandResponse = this.modelMapperService.forResponse().map(brand,GetBrandResponse.class);
        return getBrandResponse;
    }

    private void brandShouldBeExist(Optional<Brand> brand) {
        if (brand.isEmpty()) {
            throw new RuntimeException(brandNotFound);
        }
    }

    private void brandNameCanNotBeDuplicatedWhenUpdated(Brand brand) {
        boolean exists = brandRepository.existsByNameIgnoreCaseAndIdIsNot(brand.getName().trim(), brand.getId());
        if (exists) {
            throw new RuntimeException(brandAlreadyExists);
        }


    }
}


//ioc nedir?
