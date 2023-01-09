package DBAppsIntroductionLAB;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Diablo {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT" +
                " `u`.`first_name`," +
                " `u`.`last_name`," +
                " COUNT(`ug`.`user_id`) AS `games_played`" +
                " FROM`users` AS `u`" +
                " JOIN `users_games` AS `ug` ON `u`.`id` = `ug`.`user_id`" +
                " WHERE`u`.`user_name` = ?");

        preparedStatement.setString(1, username);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {

            if (result.getString("first_name") == null) {
                System.out.println("No such user exists");
            } else {
                System.out.println(result.getString("first_name") + " " +
                        result.getString("last_name") + " has played " +
                        result.getInt("games_played") + " games");
            }
        }
        connection.close();
    }
}
