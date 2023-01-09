package DBAppsIntroductionEXERCISES;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class PrintAllMinionNames {

    private static final String FIND_COUNT_OF_ALL_MINIONS = "SELECT COUNT(`m`.`id`) AS `minions_count` FROM `minions` AS `m`";
    private static final String MINION_NAME_BY_ID = "SELECT `name` FROM `minions` WHERE `id` = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement countOfMinions = connection.prepareStatement(FIND_COUNT_OF_ALL_MINIONS);
        ResultSet countOfMinionsResult = countOfMinions.executeQuery();
        countOfMinionsResult.next();

        int countOfAllMinions = countOfMinionsResult.getInt("minions_count");

        PreparedStatement minionNameStatement = connection.prepareStatement(MINION_NAME_BY_ID);

        for (int i = 1; i <= countOfAllMinions; i++) {
            minionNameStatement.setInt(1, i);
            ResultSet firstMinion = minionNameStatement.executeQuery();
            firstMinion.next();

            System.out.println(firstMinion.getString("name"));

            minionNameStatement.setInt(1, countOfAllMinions--);
            ResultSet lastMinion = minionNameStatement.executeQuery();
            lastMinion.next();

            System.out.println(lastMinion.getString("name"));
        }

        connection.close();
    }
}
