package demo.json.domain.DTOs.products;

import demo.json.domain.DTOs.categories.CategoryDTO;
import demo.json.domain.DTOs.users.UserDTO;
import demo.json.domain.entities.Category;
import demo.json.domain.entities.Product;
import demo.json.domain.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Set;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private String name;

    private BigDecimal price;

    private UserDTO buyer;

    private UserDTO seller;

    private Set<CategoryDTO> categories;

    public ProductInRangeWithNoBuyerDTO toProductInRangeWithNoBuyerDto() {
        return new ProductInRangeWithNoBuyerDTO(name, price, seller.getFullName());
    }

    public ProductsSoldWithCountDTO toProductsSoldWithCountDTO(){
        return  new ProductsSoldWithCountDTO();
    }


}
