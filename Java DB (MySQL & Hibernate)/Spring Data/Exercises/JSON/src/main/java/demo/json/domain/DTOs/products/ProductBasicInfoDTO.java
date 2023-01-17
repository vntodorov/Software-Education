package demo.json.domain.DTOs.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductBasicInfoDTO {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "price")
    private BigDecimal price;


}
