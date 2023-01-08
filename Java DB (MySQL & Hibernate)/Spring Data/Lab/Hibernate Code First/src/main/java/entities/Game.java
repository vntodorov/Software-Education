package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    @OneToOne
    @JoinColumn
    private Team homeTeam;

    @OneToOne
    @JoinColumn
    private Team awayTeam;

    @Column
    private short homeGoals;

    @Column
    private short awayGoals;

    @Column
    private Date dateAndTime;

    @Column
    private double homeTeamWinBetRate;

    @Column
    private double awayTeamWinBetRate;

    @Column
    private double drawGameBetRate;

    @ManyToOne
    @JoinColumn
    private Round round;

    @ManyToOne
    @JoinColumn
    private Competition competition;

}
