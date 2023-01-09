package DBAppsIntroductionEXERCISES;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class GetMinionsName {

    private static final String GET_MINION_NAMES_AND_AGE_BY_VILLAIN_ID = "SELECT" +
            " `m`.`name`, `m`.`age`" +
            " FROM" +
            " `minions` AS `m`" +
            " JOIN" +
            " `minions_villains` AS `mv` ON `m`.`id` = `mv`.`minion_id`" +
            " WHERE" +
            " `mv`.`villain_id` = ?";

    private static final String GET_VILLAIN_NAME = "SELECT `v`.`name` FROM `villains` AS `v` WHERE `v`.`id` = ?";

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement villainStatement = connection.prepareStatement(GET_VILLAIN_NAME);

        int villainId = Integer.parseInt(scanner.nextLine());
        villainStatement.setInt(1, villainId);
        ResultSet villainResult = villainStatement.executeQuery();

        if (!villainResult.next()) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            connection.close();
            return;
        }
        String villainName = villainResult.getString("name");
        System.out.printf("Villain: %s%n", villainName);

        PreparedStatement minionsStatement = connection.prepareStatement(GET_MINION_NAMES_AND_AGE_BY_VILLAIN_ID);
        minionsStatement.setInt(1, villainId);
        ResultSet minionsResult = minionsStatement.executeQuery();

        for (int i = 1; minionsResult.next(); i++) {
            System.out.printf("%d. %s %d%n", i, minionsResult.getString("name"), minionsResult.getInt("age"));

        }

        connection.close();

    }
}
