package EXAM.christmasPastryShop;

import EXAM.christmasPastryShop.core.ControllerImpl;
import EXAM.christmasPastryShop.core.EngineImpl;
import EXAM.christmasPastryShop.core.interfaces.Controller;
import EXAM.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import EXAM.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import EXAM.christmasPastryShop.entities.booths.interfaces.Booth;
import EXAM.christmasPastryShop.io.ConsoleReader;
import EXAM.christmasPastryShop.io.ConsoleWriter;
import EXAM.christmasPastryShop.repositories.BoothRepositoryImpl;
import EXAM.christmasPastryShop.repositories.CocktailRepositoryImpl;
import EXAM.christmasPastryShop.repositories.DelicacyRepositoryImpl;
import EXAM.christmasPastryShop.repositories.interfaces.BoothRepository;
import EXAM.christmasPastryShop.repositories.interfaces.CocktailRepository;
import EXAM.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class Main {
    public static void main(String[] args) {
        String a = " ";
        int a1 = a.length();
        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl();
        CocktailRepository<Cocktail> cocktailRepository = new CocktailRepositoryImpl();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl();

        Controller controller = new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
