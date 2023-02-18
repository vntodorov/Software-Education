package com.resellerapp.model.entity;

import com.resellerapp.model.entity.enums.ConditionEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionEnum name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    public ConditionEnum getName() {
        return name;
    }

    public void setName(ConditionEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
