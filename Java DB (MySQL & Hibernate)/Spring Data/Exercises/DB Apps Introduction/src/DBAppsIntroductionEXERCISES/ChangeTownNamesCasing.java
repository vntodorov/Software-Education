package DBAppsIntroductionEXERCISES;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ChangeTownNamesCasing {

    private static final String GET_ALL_TOWNS_OF_COUNTRY = "SELECT `name` FROM `towns` WHERE `country` = ?";
    private static final String UPDATE_TOWN = "UPDATE `towns` SET `name` = UPPER(`name`) WHERE `country` = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        String country = scanner.nextLine();

        PreparedStatement updateStatement = connection.prepareStatement(UPDATE_TOWN);
        updateStatement.setString(1, country);
        int updatedCount = updateStatement.executeUpdate();

        if (updatedCount == 0) {
            System.out.println("No town names were affected.");
            connection.close();
            return;
        }

        System.out.printf("%d town names were affected.%n", updatedCount);

        PreparedStatement countTownsStatement = connection.prepareStatement(GET_ALL_TOWNS_OF_COUNTRY);
        countTownsStatement.setString(1, country);
        ResultSet countResult = countTownsStatement.executeQuery();

        List<String> towns = new ArrayList<>();

        while (countResult.next()) {
            towns.add(countResult.getString("name"));
        }

        System.out.println(towns);

    }
}
