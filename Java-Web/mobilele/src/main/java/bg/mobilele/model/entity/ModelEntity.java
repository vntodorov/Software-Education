package bg.mobilele.model.entity;

import bg.mobilele.model.entity.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;

    private String imageUrl;

    private int startYear;

    private Long endYear;

    @ManyToOne
    private BrandEntity brand;


}
