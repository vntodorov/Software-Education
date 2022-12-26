package ExamPreparation.football.entities.player;

import ExamPreparation.football.common.ExceptionMessages;

public abstract class BasePlayer implements Player {

    private String name;

    private String nationality;

    private double kg;

    private int strength;

    protected BasePlayer(String name, String nationality, double kg, int strength) {
        setName(name);
        setNationality(nationality);
        setKg(kg);
        setStrength(strength);
    }

    public void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }
        this.strength = strength;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }
        this.nationality = name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLAYER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public double getKg() {
        return kg;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }


}
