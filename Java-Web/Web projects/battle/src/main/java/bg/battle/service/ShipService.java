package bg.battle.service;

import bg.battle.model.Category;
import bg.battle.model.DTOs.CreateShipDTO;
import bg.battle.model.Ship;
import bg.battle.model.User;
import bg.battle.model.enums.CategoryEnum;
import bg.battle.repository.CategoryRepository;
import bg.battle.repository.ShipRepository;
import bg.battle.repository.UserRepository;
import bg.battle.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    @Autowired
    public ShipService(ShipRepository shipRepository, CategoryRepository categoryRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean createShip(CreateShipDTO shipDTO) {
        Optional<Ship> byName =
                this.shipRepository.findByName(shipDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

        CategoryEnum type = switch (shipDTO.getCategory()) {
            case 0 -> CategoryEnum.BATTLE;
            case 1 -> CategoryEnum.CARGO;
            case 2 -> CategoryEnum.PATROL;
            default -> CategoryEnum.BATTLE;
        };

        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.currentUser.getId());

        Ship ship = new Ship();
        ship.setName(shipDTO.getName());
        ship.setPower(shipDTO.getPower());
        ship.setHealth(shipDTO.getHealth());
        ship.setCreated(shipDTO.getCreated());
        ship.setCategory(category);
        ship.setOwner(owner.get());

        this.shipRepository.save(ship);

        return true;

    }
}
