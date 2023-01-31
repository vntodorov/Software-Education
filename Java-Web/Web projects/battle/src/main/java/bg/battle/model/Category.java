package bg.battle.model;

import bg.battle.model.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntityId{

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEnum getName() {
        return name;
    }

    public Category(){}

    public Category(CategoryEnum name){
        this.name = name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
