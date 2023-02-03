package bg.battle.repository;

import bg.battle.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);

    Optional<List<Ship>> findByUserId(long id);

    Optional<List<Ship>> findByUserIdNot(long id);

    Optional<List<Ship>> findByOrderByHealthAscNameDescPowerAsc();


}
