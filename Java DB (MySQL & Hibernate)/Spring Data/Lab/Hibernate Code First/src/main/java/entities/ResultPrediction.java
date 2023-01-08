package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private ResultPredictionValues prediction;
}
