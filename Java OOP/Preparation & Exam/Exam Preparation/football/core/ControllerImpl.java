package ExamPreparation.football.core;


import ExamPreparation.football.common.ConstantMessages;
import ExamPreparation.football.common.ExceptionMessages;
import ExamPreparation.football.entities.field.ArtificialTurf;
import ExamPreparation.football.entities.field.Field;
import ExamPreparation.football.entities.field.NaturalGrass;
import ExamPreparation.football.entities.player.Men;
import ExamPreparation.football.entities.player.Player;
import ExamPreparation.football.entities.player.Women;
import ExamPreparation.football.entities.supplement.Liquid;
import ExamPreparation.football.entities.supplement.Powdered;
import ExamPreparation.football.entities.supplement.Supplement;
import ExamPreparation.football.repositories.SupplementRepository;
import ExamPreparation.football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplementRepository;
    private Collection<Field> fields;

    public ControllerImpl() {
        supplementRepository = new SupplementRepositoryImpl();
        fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {

        switch (fieldType) {
            case "ArtificialTurf":
                fields.add(new ArtificialTurf(fieldName));
                break;
            case "NaturalGrass":
                fields.add(new NaturalGrass(fieldName));
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {

        switch (type) {
            case "Powdered":
                supplementRepository.add(new Powdered());
                break;
            case "Liquid":
                supplementRepository.add(new Liquid());
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement desiredSupplement = supplementRepository.findByType(supplementType);
        if (desiredSupplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = getFieldByName(fieldName);

        field.addSupplement(desiredSupplement);
        supplementRepository.remove(desiredSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field field = getFieldByName(fieldName);
        switch (playerType) {
            case "Men":
                if (!field.getClass().getSimpleName().equals("NaturalGrass")) {
                    return ConstantMessages.FIELD_NOT_SUITABLE;
                }
                field.addPlayer(new Men(playerName, nationality, strength));
                break;
            case "Women":
                if (!field.getClass().getSimpleName().equals("ArtificialTurf")) {
                    return ConstantMessages.FIELD_NOT_SUITABLE;
                }
                field.addPlayer(new Women(playerName, nationality, strength));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);
        field.drag();
        return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getFieldByName(fieldName);
        int strengthValue = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, strengthValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        for (Field field : fields) {
            out.append(field.getInfo());
            out.append(System.lineSeparator());
        }
        return out.toString().trim();
    }

    private Field getFieldByName(String fieldName) {
        return fields.stream()
                .filter(f -> f.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }
}
