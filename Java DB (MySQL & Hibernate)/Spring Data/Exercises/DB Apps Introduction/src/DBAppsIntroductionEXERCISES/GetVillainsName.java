package DBAppsIntroductionEXERCISES;

import java.sql.*;
import java.util.Properties;

public class GetVillainsName {
    private static final String GET_VILLAINS_NAMES_SQL = "SELECT " +
            "`v`.`name`, " +
            "COUNT(DISTINCT `mv`.`minion_id`) AS `total_minions` " +
            "FROM `villains` AS `v` " +
            "JOIN `minions_villains` AS `mv` ON `v`.`id` = `mv`.`villain_id` " +
            "GROUP BY `v`.`id` " +
            "HAVING `total_minions` > 15 " +
            "ORDER BY `total_minions` DESC";

    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);


        PreparedStatement preparedStatement = connection.prepareStatement(GET_VILLAINS_NAMES_SQL);

        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            System.out.println(result.getString("name") + " " + result.getInt("total_minions"));

        }

        connection.close();

    }

}
