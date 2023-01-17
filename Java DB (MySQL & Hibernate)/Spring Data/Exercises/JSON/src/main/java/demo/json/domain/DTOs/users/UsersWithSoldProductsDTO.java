package demo.json.domain.DTOs.users;

import demo.json.domain.DTOs.products.ProductSoldDTO;
import demo.json.domain.DTOs.products.ProductSoldWrapperDTO;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersWithSoldProductsDTO {

    private String firstName;

    private String lastName;

    private List<ProductSoldDTO> boughtProducts;

    public static List<UsersWithSoldProductsXmlWrapperDTO> toUsersWithSoldProductsDTO(List<UsersWithSoldProductsDTO> input) {
        return input
                .stream()
                .map(u -> new UsersWithSoldProductsXmlWrapperDTO(
                        u.getFirstName(),
                        u.getLastName(),
                        new ProductSoldWrapperDTO(u.getBoughtProducts())))
                .toList();
    }
}
