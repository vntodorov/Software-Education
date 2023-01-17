package demo.json.services;

import demo.json.domain.DTOs.users.UserWithProductsDTO;
import demo.json.domain.DTOs.users.UsersWithProductWrapperDTO;
import demo.json.domain.DTOs.users.UsersWithSoldProductsDTO;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    List<UsersWithSoldProductsDTO> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName() throws IOException, JAXBException;

    UsersWithProductWrapperDTO usersAndProducts() throws IOException, JAXBException;

}
