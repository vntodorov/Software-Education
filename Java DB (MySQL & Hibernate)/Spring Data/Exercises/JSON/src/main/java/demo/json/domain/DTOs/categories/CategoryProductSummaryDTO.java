package demo.json.domain.DTOs.categories;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryProductSummaryDTO {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "products-count")
    private Long productCount;

    @XmlElement(name = "average-price")
    private Double averagePrice;

    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;
}
