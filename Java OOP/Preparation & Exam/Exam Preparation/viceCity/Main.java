package ExamPreparation.viceCity;

import ExamPreparation.viceCity.core.ControllerImpl;
import ExamPreparation.viceCity.core.EngineImpl;
import ExamPreparation.viceCity.core.interfaces.Controller;
import ExamPreparation.viceCity.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
