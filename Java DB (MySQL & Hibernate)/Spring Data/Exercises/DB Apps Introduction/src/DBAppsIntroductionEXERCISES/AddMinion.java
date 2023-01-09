package DBAppsIntroductionEXERCISES;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class AddMinion {

    private static final String INSERT_NEW_MINION = "INSERT INTO `minions`(`name`, `age`, `town_id`) VALUES (?, ?, ?)";
    private static final String INSERT_NEW_TOWN = "INSERT INTO `towns`(`name`) VALUES (?)";
    private static final String INSERT_NEW_VILLAIN = "INSERT INTO `villains`(`name`, `evilness_factor`) VALUES (?, 'evil')";
    private static final String INSERT_NEW_RELATIONSHIP_BETWEEN_MINION_AND_VILLAIN = "INSERT INTO `minions_villains`(`minion_id`, `villain_id`) VALUES (?, ?)";
    private static final String FIND_TOWN_BY_NAME = "SELECT * FROM `towns` WHERE `name` = ?";
    private static final String FIND_ID_OF_TOWN_BY_NAME = "SELECT `id` FROM `towns` WHERE `name` = ?";
    private static final String FIND_VILLAIN_BY_NAME = "SELECT * FROM `villains` WHERE `name` = ?";
    private static final String FIND_ID_OF_VILLAIN_BY_NAME = "SELECT `id` FROM `villains` WHERE `name` = ?";
    private static final String FIND_ID_OF_MINION_BY_NAME = "SELECT `id` FROM `minions` WHERE `name` = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        String[] minionData = scanner.nextLine().split("\\s+");
        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String minionTown = minionData[3];

        String villainName = scanner.nextLine().split("\\s+")[1];

        PreparedStatement findTownStatement = connection.prepareStatement(FIND_TOWN_BY_NAME);
        findTownStatement.setString(1, minionTown);
        ResultSet townResult = findTownStatement.executeQuery();

        if (!townResult.next()) {
            PreparedStatement insertTownStatement = connection.prepareStatement(INSERT_NEW_TOWN);
            insertTownStatement.setString(1, minionTown);
            insertTownStatement.execute();
            System.out.printf("Town %s was added to the database.%n", minionTown);

        }

        PreparedStatement findVillainStatement = connection.prepareStatement(FIND_VILLAIN_BY_NAME);
        findVillainStatement.setString(1, villainName);
        ResultSet villainResult = findVillainStatement.executeQuery();

        if (!villainResult.next()) {
            PreparedStatement insertVillainStatement = connection.prepareStatement(INSERT_NEW_VILLAIN);
            insertVillainStatement.setString(1, villainName);
            insertVillainStatement.execute();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        PreparedStatement findTownID = connection.prepareStatement(FIND_ID_OF_TOWN_BY_NAME);
        findTownID.setString(1, minionTown);
        ResultSet findTownIDResult = findTownID.executeQuery();
        findTownIDResult.next();
        int minionTownID = findTownIDResult.getInt("id");

        PreparedStatement insertMinion = connection.prepareStatement(INSERT_NEW_MINION);
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, minionTownID);
        insertMinion.execute();

        PreparedStatement findMinionID = connection.prepareStatement(FIND_ID_OF_MINION_BY_NAME);
        findMinionID.setString(1, minionName);
        ResultSet findMinionIDResult = findMinionID.executeQuery();
        findMinionIDResult.next();
        int minionID = findMinionIDResult.getInt("id");

        PreparedStatement findVillainID = connection.prepareStatement(FIND_ID_OF_VILLAIN_BY_NAME);
        findVillainID.setString(1, villainName);
        ResultSet findVillainIDResult = findVillainID.executeQuery();
        findVillainIDResult.next();
        int villainID = findVillainIDResult.getInt("id");

        PreparedStatement insertNewRelationship = connection.prepareStatement(INSERT_NEW_RELATIONSHIP_BETWEEN_MINION_AND_VILLAIN);
        insertNewRelationship.setInt(1, minionID);
        insertNewRelationship.setInt(2, villainID);
        insertNewRelationship.execute();

        System.out.printf("Successfully added %s to be minion of %s", minionName, villainName);

        connection.close();

    }
}
