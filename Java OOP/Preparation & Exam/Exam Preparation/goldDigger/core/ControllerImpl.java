package ExamPreparation.goldDigger.core;

import ExamPreparation.goldDigger.common.ConstantMessages;
import ExamPreparation.goldDigger.common.ExceptionMessages;
import ExamPreparation.goldDigger.models.discoverer.Anthropologist;
import ExamPreparation.goldDigger.models.discoverer.Archaeologist;
import ExamPreparation.goldDigger.models.discoverer.Discoverer;
import ExamPreparation.goldDigger.models.discoverer.Geologist;
import ExamPreparation.goldDigger.models.operation.Operation;
import ExamPreparation.goldDigger.models.operation.OperationImpl;
import ExamPreparation.goldDigger.models.spot.Spot;
import ExamPreparation.goldDigger.models.spot.SpotImpl;
import ExamPreparation.goldDigger.repositories.DiscovererRepository;
import ExamPreparation.goldDigger.repositories.Repository;
import ExamPreparation.goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Discoverer> discoverers;
    private Repository<Spot> spots;

    private int spotsInspected = 0;

    public ControllerImpl() {
        discoverers = new DiscovererRepository();
        spots = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind) {
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);

        }
        discoverers.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        spots.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discoverers.byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discoverers.remove(discoverer);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Spot spot = spots.byName(spotName);
        List<Discoverer> suitableDiscoverers = discoverers.getCollection().stream().filter(d -> d.getEnergy() > 45).collect(Collectors.toList());
        if (suitableDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Operation operation = new OperationImpl();
        operation.startOperation(spot, suitableDiscoverers);
        long excluded = suitableDiscoverers.stream().filter(d -> d.getEnergy() == 0).count();
        spotsInspected++;
        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excluded);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, spotsInspected))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_DISCOVERER_INFO)
                .append(System.lineSeparator());

        for (Discoverer discoverer : discoverers.getCollection()) {
            out.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, discoverer.getMuseum().getExhibits().size() > 0
                            ? String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits())
                            : "None"))
                    .append(System.lineSeparator());
        }

        return out.toString().trim();

    }
}
