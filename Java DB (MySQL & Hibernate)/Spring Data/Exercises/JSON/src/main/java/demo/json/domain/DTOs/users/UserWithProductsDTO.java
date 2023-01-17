package demo.json.domain.DTOs.users;

import demo.json.domain.DTOs.products.ProductsSoldWithCountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithProductsDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "age")
    private int age;

    @XmlElement(name = "sold-products")
    private ProductsSoldWithCountDTO products;
}
