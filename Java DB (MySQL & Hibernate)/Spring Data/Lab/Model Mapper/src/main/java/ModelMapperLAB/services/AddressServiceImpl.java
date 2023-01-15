package ModelMapperLAB.services;

import ModelMapperLAB.entities.Address;
import ModelMapperLAB.entities.DTOs.AddressDTO;
import ModelMapperLAB.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    private final ModelMapper mapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper mapper) {
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    public Address create(AddressDTO data) {
        ModelMapper mapper = new ModelMapper();
        Address address = mapper.map(data, Address.class);


        return this.addressRepository.save(address);
    }
}
