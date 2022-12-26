package ExamPreparation.football;

import ExamPreparation.football.core.Engine;
import ExamPreparation.football.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
