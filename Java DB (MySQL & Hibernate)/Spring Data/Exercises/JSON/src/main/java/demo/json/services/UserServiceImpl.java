package demo.json.services;

import demo.json.domain.DTOs.users.*;
import demo.json.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static demo.json.constants.Paths.*;
import static demo.json.constants.Utils.writeJsonIntoFile;
import static demo.json.constants.Utils.writeXmlIntoFile;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UsersWithSoldProductsDTO> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName() throws IOException, JAXBException {
        List<UsersWithSoldProductsDTO> usersForJson = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName().orElseThrow()
                .stream()
                .map(user -> mapper.map(user, UsersWithSoldProductsDTO.class))
                .collect(Collectors.toList());

        UsersWithSoldProductsWrapperDTO usersForXml = new UsersWithSoldProductsWrapperDTO();
        usersForXml.ofListOfUsersWithSoldProductsDTO(usersForJson);

        writeXmlIntoFile(usersForXml, USERS_SOLD_PRODUCTS_XML);

        writeJsonIntoFile(usersForJson, USERS_SOLD_PRODUCTS);

        return usersForJson;
    }

    @Override
    public UsersWithProductWrapperDTO usersAndProducts() throws IOException, JAXBException {

        List<UserWithProductsDTO> usersAndProducts = this.userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName().orElseThrow()
                .stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .map(UserDTO::toUserWithProductsDTO)
                .collect(Collectors.toList());

        UsersWithProductWrapperDTO usersWithProductWrapperDTO = new UsersWithProductWrapperDTO(usersAndProducts);

        writeXmlIntoFile(usersWithProductWrapperDTO, USERS_AND_PRODUCTS_XML);
        writeJsonIntoFile(usersWithProductWrapperDTO, USERS_AND_PRODUCTS);

        return usersWithProductWrapperDTO;
    }
}
