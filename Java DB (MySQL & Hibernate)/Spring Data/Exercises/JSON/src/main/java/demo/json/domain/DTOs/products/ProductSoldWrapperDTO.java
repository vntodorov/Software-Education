package demo.json.domain.DTOs.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldWrapperDTO {

    @XmlElement(name = "product")
    private List<ProductSoldDTO> boughtProducts;
}
