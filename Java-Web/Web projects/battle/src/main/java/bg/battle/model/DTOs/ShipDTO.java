package bg.battle.model.DTOs;

import bg.battle.model.Ship;

import java.util.List;

public class ShipDTO {

    private long id;

    private String name;

    private long health;

    private long power;

    public ShipDTO(Ship ship) {
        this.id = ship.getId();
        this.name = ship.getName();
        this.health = ship.getHealth();
        this.power = ship.getPower();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getHealth() {
        return health;
    }

    public long getPower() {
        return power;
    }
}
