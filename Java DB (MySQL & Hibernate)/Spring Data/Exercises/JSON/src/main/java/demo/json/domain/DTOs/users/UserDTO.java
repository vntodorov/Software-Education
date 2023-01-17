package demo.json.domain.DTOs.users;

import demo.json.domain.DTOs.products.ProductBasicInfoDTO;
import demo.json.domain.DTOs.products.ProductDTO;
import demo.json.domain.DTOs.products.ProductsSoldWithCountDTO;
import demo.json.domain.entities.Product;
import demo.json.domain.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String firstName;

    private String lastName;

    private int age;

    private Set<ProductDTO> sellingProducts;

    private Set<ProductDTO> boughtProducts;

    private Set<UserDTO> friends;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public UserWithProductsDTO toUserWithProductsDTO(){
        return new UserWithProductsDTO(firstName, lastName, age, toProductsSoldWithCountDTO());
    }

    public ProductsSoldWithCountDTO toProductsSoldWithCountDTO(){
        return new ProductsSoldWithCountDTO(sellingProducts.stream().map(this::toProductBasicInfoDTO).collect(Collectors.toList()));
    }

    public ProductBasicInfoDTO toProductBasicInfoDTO(ProductDTO productDTO){
        return new ProductBasicInfoDTO(productDTO.getName(), productDTO.getPrice());

    }


}
