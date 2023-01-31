package bg.battle.seeder;

import bg.battle.model.Category;
import bg.battle.model.enums.CategoryEnum;
import bg.battle.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0) {

            List<Category> categories = Arrays.stream(CategoryEnum.values())
                    .map(Category::new)
                    .toList();

            categoryRepository.saveAll(categories);

        }
    }
}
