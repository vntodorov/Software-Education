package DBAppsIntroductionEXERCISES;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class RemoveVillain {

    private static final String FIND_COUNT_MINIONS_OF_VILLAIN = "SELECT COUNT(`mv`.`minion_id`) AS `minions_count` FROM `villains` AS `v` JOIN `minions_villains` AS `mv` ON `v`.`id` = `mv`.`villain_id` WHERE `v`.`id` = ?";
    private static final String FIND_VILLAIN_BY_ID = "SELECT `name` FROM `villains` WHERE `id` = ?";
    private static final String DELETE_VILLAIN_BY_ID = "DELETE FROM `villains` WHERE `id` = ?";
    private static final String RELEASE_MINIONS = "DELETE FROM `minions_villains` WHERE `villain_id` = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        int villainToDeleteID = Integer.parseInt(scanner.nextLine());

        PreparedStatement villainByID = connection.prepareStatement(FIND_VILLAIN_BY_ID);
        villainByID.setInt(1, villainToDeleteID);
        ResultSet villainIDResult = villainByID.executeQuery();

        if (!villainIDResult.next()) {
            System.out.println("No such villain was found");
            connection.close();
            return;
        }

        String villainName = villainIDResult.getString("name");


        PreparedStatement minionsOfVillain = connection.prepareStatement(FIND_COUNT_MINIONS_OF_VILLAIN);
        minionsOfVillain.setInt(1, villainToDeleteID);
        ResultSet countMinionsResult = minionsOfVillain.executeQuery();
        countMinionsResult.next();
        int countOfMinions = countMinionsResult.getInt("minions_count");

        connection.setAutoCommit(false);


        try (
                PreparedStatement releaseMinions = connection.prepareStatement(RELEASE_MINIONS);
                PreparedStatement deleteVillain = connection.prepareStatement(DELETE_VILLAIN_BY_ID)) {
            releaseMinions.setInt(1, villainToDeleteID);
            releaseMinions.execute();

            deleteVillain.setInt(1, villainToDeleteID);
            deleteVillain.execute();

            connection.commit();
            System.out.println(villainName + " was deleted");
            System.out.println(countOfMinions + " minions released");

        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();

        }
    }
}
