package ExamPreparation.zoo;

import ExamPreparation.zoo.core.Engine;
import ExamPreparation.zoo.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
