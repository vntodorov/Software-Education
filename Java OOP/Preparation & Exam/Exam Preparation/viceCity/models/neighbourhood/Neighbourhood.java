package ExamPreparation.viceCity.models.neighbourhood;

import ExamPreparation.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
