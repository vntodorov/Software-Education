package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    private String logo;

    @Column(length = 3, nullable = false)
    private String initials;

    @ManyToOne
    @JoinColumn
    private Color primaryColor;

    @ManyToOne
    @JoinColumn
    private Color secondaryColor;

    @ManyToOne
    private Town town;

    @Column
    private BigInteger budget;


}
