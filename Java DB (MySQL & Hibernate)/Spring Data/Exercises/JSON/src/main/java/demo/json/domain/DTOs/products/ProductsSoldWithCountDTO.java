package demo.json.domain.DTOs.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSoldWithCountDTO {

    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "product")
    private List<ProductBasicInfoDTO> products;

    public ProductsSoldWithCountDTO(List<ProductBasicInfoDTO> products) {
        this.products = products;
        this.count = products.size();
    }
}
