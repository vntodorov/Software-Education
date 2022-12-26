package ExamPreparation.viceCity.core;

import static ExamPreparation.viceCity.common.ConstantMessages.*;

import ExamPreparation.viceCity.core.interfaces.Controller;
import ExamPreparation.viceCity.models.guns.Gun;
import ExamPreparation.viceCity.models.guns.Pistol;
import ExamPreparation.viceCity.models.guns.Rifle;
import ExamPreparation.viceCity.models.neighbourhood.GangNeighbourhood;
import ExamPreparation.viceCity.models.neighbourhood.Neighbourhood;
import ExamPreparation.viceCity.models.players.CivilPlayer;
import ExamPreparation.viceCity.models.players.MainPlayer;
import ExamPreparation.viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private Player mainPlayer;

    private Collection<Player> players;

    private ArrayDeque<Gun> guns;

    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new ArrayList<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        players.add(civilPlayer);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;

        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }

        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        Player player = players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);

        if (player == null && !name.equals("Vercetti")) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        Gun gunToAdd = guns.poll();

        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gunToAdd);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gunToAdd.getName(), mainPlayer.getName());
        } else {
            player.getGunRepository().add(gunToAdd);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunToAdd.getName(), player.getName());
        }


    }

    @Override
    public String fight() {
        int mainPlayerLifePointsBefore = mainPlayer.getLifePoints();
        int civilPlayersLifePointsBefore = players.stream().filter(Player::isAlive).mapToInt(Player::getLifePoints).sum();

        neighbourhood.action(mainPlayer, players);

        int civilPlayersLifePointsAfter = players.stream().filter(Player::isAlive).mapToInt(Player::getLifePoints).sum();

        if (mainPlayer.getLifePoints() != mainPlayerLifePointsBefore || civilPlayersLifePointsAfter != civilPlayersLifePointsBefore) {
            StringBuilder out = new StringBuilder();
            out.append(FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, players.stream().filter(p -> !p.isAlive()).count()))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, players.stream().filter(Player::isAlive).count()));
            return out.toString().trim();
        } else {
            return FIGHT_HOT_HAPPENED;
        }

    }
}
