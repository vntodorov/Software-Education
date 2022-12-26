package ExamPreparation.football.entities.field;

import ExamPreparation.football.common.ConstantMessages;
import ExamPreparation.football.common.ExceptionMessages;
import ExamPreparation.football.entities.player.Player;
import ExamPreparation.football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {

    private String name;

    private int capacity;

    private Collection<Supplement> supplements;

    private Collection<Player> players;

    protected BaseField(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        supplements = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int sumEnergy() {
        return supplements.stream().mapToInt(Supplement::getEnergy).sum();
    }

    public void addPlayer(Player player) {
        if (player.getKg() >= capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    public void drag() {
        players.forEach(Player::stimulation);
    }

    public String getInfo() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("%s (%s):", getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Player: ");

        if (players.isEmpty()) {
            out.append("none");
        } else {
            out.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }

        out.append(System.lineSeparator())
                .append("Supplement: ")
                .append(supplements.size())
                .append(System.lineSeparator())
                .append("Energy: ")
                .append(sumEnergy());

        return out.toString().trim();
    }

    public Collection<Player> getPlayers() {
        return this.players;
    }

    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    public String getName() {
        return this.name;
    }

}
