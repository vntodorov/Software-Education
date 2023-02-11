package bg.mobilele.service;

import bg.mobilele.model.dto.brand.BrandDTO;
import bg.mobilele.model.dto.model.ModelDTO;
import bg.mobilele.model.entity.BrandEntity;
import bg.mobilele.model.entity.ModelEntity;
import bg.mobilele.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public List<BrandDTO> getAllBrands(){
        return brandRepository.findAll().stream().map(this::mapBrand).toList();
    }

    private BrandDTO mapBrand(BrandEntity brand){
        List<ModelDTO> models = brand.getModels()
                .stream()
                .map(this::mapModel)
                .toList();

        return new BrandDTO()
                .setModels(models)
                .setName(brand.getName());
    }

    private ModelDTO mapModel(ModelEntity model){
        return new ModelDTO().setId(model.getId()).setName(model.getName());
    }
}
