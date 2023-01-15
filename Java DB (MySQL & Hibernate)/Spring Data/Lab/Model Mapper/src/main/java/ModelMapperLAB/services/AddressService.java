package ModelMapperLAB.services;

import ModelMapperLAB.entities.Address;
import ModelMapperLAB.entities.DTOs.AddressDTO;

public interface AddressService {

    Address create(AddressDTO data);
}
