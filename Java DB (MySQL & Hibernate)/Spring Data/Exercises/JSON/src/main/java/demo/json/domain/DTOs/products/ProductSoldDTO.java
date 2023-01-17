package demo.json.domain.DTOs.products;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldDTO {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "buyer-first-name")
    private String buyerFirstName;

    @XmlElement(name = "buyer-last-name")
    private String buyerLastName;
}
