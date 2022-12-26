package ExamPreparation.fairyShop.core;

import static ExamPreparation.fairyShop.common.ExceptionMessages.*;

import static ExamPreparation.fairyShop.common.ConstantMessages.*;

import ExamPreparation.fairyShop.models.*;
import ExamPreparation.fairyShop.repositories.HelperRepository;
import ExamPreparation.fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Shop shop;

    private HelperRepository helpers;

    private PresentRepository presents;

    public ControllerImpl() {
        this.shop = new ShopImpl();
        this.helpers = new HelperRepository();
        this.presents = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helpers.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helpers.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presents.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present presentToCraft = presents.findByName(presentName);
        List<Helper> helpersToCraft = helpers.getModels().stream().filter(h -> h.getEnergy() > 50).collect(Collectors.toList());
        if (helpersToCraft.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        int brokenInstruments = 0;
        for (Helper helper : helpersToCraft) {
            shop.craft(presentToCraft, helper);
            brokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (presentToCraft.isDone()){
                break;
            }

        }
        return String.format(PRESENT_DONE, presentName, presentToCraft.isDone() ? "done" : "not done") + String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {
        long craftedPresents = presents.getModels().stream().filter(Present::isDone).count();
        StringBuilder out = new StringBuilder();
        out.append(String.format("%d presents are done!", craftedPresents))
                .append(System.lineSeparator())
                .append("Helpers info:")
                .append(System.lineSeparator());

        for (Helper helper : helpers.getModels()) {
            out.append(String.format("Name: %s%n", helper.getName()));
            out.append(String.format("Energy: %d%n", helper.getEnergy()));
            long notBrokenInstruments = helper.getInstruments().stream().filter(i -> !i.isBroken()).count();
            out.append(String.format("Instruments: %d not broken left%n", notBrokenInstruments));
        }

        return out.toString().trim();
    }
}
