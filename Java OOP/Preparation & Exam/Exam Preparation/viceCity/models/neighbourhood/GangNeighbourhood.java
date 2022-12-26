package ExamPreparation.viceCity.models.neighbourhood;

import ExamPreparation.viceCity.models.guns.Gun;
import ExamPreparation.viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood{

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        for (Gun gun : mainPlayer.getGunRepository().getModels()){

            for (Player player : civilPlayers){

                while (gun.canFire() && player.isAlive()){
                    player.takeLifePoints(gun.fire());
                }

            }

        }

        for (Player civilPlayer : civilPlayers){

            for (Gun gun : civilPlayer.getGunRepository().getModels()){

                while (civilPlayer.isAlive() && gun.canFire()){

                    mainPlayer.takeLifePoints(gun.fire());

                    if (!mainPlayer.isAlive()){
                        return;
                    }
                }

            }

        }
    }
}
