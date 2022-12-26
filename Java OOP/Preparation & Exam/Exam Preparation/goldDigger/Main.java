package ExamPreparation.goldDigger;

import ExamPreparation.goldDigger.core.Controller;
import ExamPreparation.goldDigger.core.ControllerImpl;
import ExamPreparation.goldDigger.core.Engine;
import ExamPreparation.goldDigger.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
