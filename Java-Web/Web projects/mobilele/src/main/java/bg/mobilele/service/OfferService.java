package bg.mobilele.service;

import bg.mobilele.model.dto.offer.AddOfferDTO;
import bg.mobilele.model.dto.offer.OfferDetailDTO;
import bg.mobilele.model.dto.offer.SearchOfferDTO;
import bg.mobilele.model.entity.ModelEntity;
import bg.mobilele.model.entity.OfferEntity;
import bg.mobilele.model.entity.UserEntity;
import bg.mobilele.model.mapper.OfferMapper;
import bg.mobilele.repository.ModelRepository;
import bg.mobilele.repository.OfferRepository;
import bg.mobilele.repository.OfferSpecification;
import bg.mobilele.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    private final UserRepository userRepository;

    private final ModelRepository modelRepository;

    private final OfferMapper offerMapper;

    @Autowired
    public OfferService(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.offerMapper = offerMapper;
    }

    public void addOffer(AddOfferDTO addOfferDTO, UserDetails userDetails) {

        OfferEntity newOffer = offerMapper
                .offerDtoToOfferEntity(addOfferDTO);


        UserEntity seller = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();


        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);


    }

    public List<OfferDetailDTO> searchOffer(SearchOfferDTO searchOfferDTO) {
        return this.offerRepository.findAll(new OfferSpecification(searchOfferDTO)).
                stream().map(offerMapper::offerEntityToOfferDetailDto).
                toList();
    }
}
