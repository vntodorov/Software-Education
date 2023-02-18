package com.resellerapp.init;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.enums.ConditionEnum;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConditionSeeder implements CommandLineRunner {

    private final ConditionRepository conditionRepository;

    @Autowired
    public ConditionSeeder(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (conditionRepository.count() == 0) {

            for (ConditionEnum conditionEnum : ConditionEnum.values()) {

                Condition condition = new Condition();

                if (conditionEnum.equals(ConditionEnum.EXCELLENT)) {
                    condition.setName(ConditionEnum.EXCELLENT);
                    condition.setDescription("In perfect condition");
                } else if (conditionEnum.equals(ConditionEnum.GOOD)) {
                    condition.setName(ConditionEnum.GOOD);
                    condition.setDescription("Some signs of wear and tear or minor defects");
                } else {
                    condition.setName(ConditionEnum.ACCEPTABLE);
                    condition.setDescription("The item is fairly worn but continues to function properly");
                }

                conditionRepository.save(condition);

            }
        }
    }
}
