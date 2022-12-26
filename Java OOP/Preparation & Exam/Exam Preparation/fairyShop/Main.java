package ExamPreparation.fairyShop;

import ExamPreparation.fairyShop.core.Engine;
import ExamPreparation.fairyShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
