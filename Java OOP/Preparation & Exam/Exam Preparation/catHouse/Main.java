package ExamPreparation.catHouse;

import ExamPreparation.catHouse.core.Engine;
import ExamPreparation.catHouse.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}
