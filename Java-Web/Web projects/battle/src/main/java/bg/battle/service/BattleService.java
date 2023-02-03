package bg.battle.service;

import bg.battle.model.DTOs.StartBattleDTO;
import bg.battle.model.Ship;
import bg.battle.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {

    private final ShipRepository shipRepository;

    @Autowired
    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(StartBattleDTO startBattleDTO) {
        Optional<Ship> attackerOpt = this.shipRepository.findById(startBattleDTO.getAttackerId());
        Optional<Ship> defenderOpt = this.shipRepository.findById(startBattleDTO.getDefenderId());

        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()){
            throw new NoSuchElementException();
        }

        Ship attack = attackerOpt.get();
        Ship defender = defenderOpt.get();

        long newDefenderPower = defender.getHealth() - attack.getPower();

        if (newDefenderPower <= 0){
            this.shipRepository.delete(defender);
        } else {
            defender.setHealth(newDefenderPower);
            this.shipRepository.save(defender);
        }

    }
}
