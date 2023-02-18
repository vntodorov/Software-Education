package com.resellerapp.service;

import com.resellerapp.model.dto.OfferDTO;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.model.entity.enums.ConditionEnum;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    private final ConditionRepository conditionRepository;

    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    @Autowired
    public OfferService(OfferRepository offerRepository, ConditionRepository conditionRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public void addOffer(OfferDTO offerDTO) {

        ConditionEnum conditionEnum;

        if (offerDTO.getCondition().equals("EXCELLENT")) {
            conditionEnum = ConditionEnum.EXCELLENT;
        } else if (offerDTO.getCondition().equals("GOOD")) {
            conditionEnum = ConditionEnum.GOOD;
        } else {
            conditionEnum = ConditionEnum.ACCEPTABLE;
        }

        Condition condition = conditionRepository.findByName(conditionEnum);
        Optional<User> owner = userRepository.findById(loggedUser.getId());

        Offer offer = new Offer();
        offer.setDescription(offerDTO.getDescription());
        offer.setPrice(offerDTO.getPrice());
        offer.setCondition(condition);

        this.offerRepository.save(offer);

        owner.get().addOffer(offerRepository.findById(offer.getId()).get());

        this.userRepository.save(owner.get());
    }

    @Transactional
    public void removeOffer(Long offerId) {
        Offer offerToRemove = offerRepository.findById(offerId).get();
        Optional<User> owner = userRepository.findById(loggedUser.getId());
        owner.get().removeOffer(offerToRemove);
        userRepository.save(owner.get());
        offerRepository.delete(offerToRemove);
    }

    public List<OfferDTO> getMadeOffers(long loggedUserId) {
        return this.userRepository.findById(loggedUserId).get().getOffers().stream().map(OfferDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public List<OfferDTO> getBoughtOffers(long loggedUserId) {
        return this.userRepository.findById(loggedUserId).get().getBoughtOffers().stream().map(OfferDTO::new).collect(Collectors.toList());

    }

    public List<OfferDTO> getOtherOffers(long loggedUserId) {
        return null;
    }
}
