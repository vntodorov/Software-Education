package demo.json.domain.DTOs.users;

import demo.json.domain.DTOs.products.ProductSoldWrapperDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithSoldProductsXmlWrapperDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "sold-products")
    private ProductSoldWrapperDTO boughtProducts;
}
