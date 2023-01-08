package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bets")
public class Bet extends BaseEntity{

    @Column(name = "bet_money")
    private BigDecimal betMoney;

    @Column(name = "time_of_bet")
    private Date timeOfBet;

    @ManyToOne
    private User user;

}
