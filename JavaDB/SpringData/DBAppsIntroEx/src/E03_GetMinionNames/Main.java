package E03_GetMinionNames;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", props);

        Scanner scanner = new Scanner(System.in);
        int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement villainStatement = connection.prepareStatement(
                "SELECT name from villains WHERE id = ?"
        );

        villainStatement.setInt(1, villainId);
        ResultSet villainSet = villainStatement.executeQuery();

        if(!villainSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        String villainName = villainSet.getString("name");
        System.out.printf("Villain: %s%n", villainName);

        PreparedStatement selectMinionsByVillain = connection.prepareStatement(
                "SELECT DISTINCT name, age FROM minions AS m" +
                        " JOIN minions_villains AS mv ON m.id = mv.minion_id" +
                        " WHERE mv.villain_id = ?"
        );
        selectMinionsByVillain.setInt(1, villainId);
        ResultSet minionSet = selectMinionsByVillain.executeQuery();

        for (int i = 1; minionSet.next(); i++) {
            String minionName = minionSet.getString("name");
            int minionAge = minionSet.getInt("age");

            System.out.printf("%d. %s %d%n", i, minionName, minionAge);
        }

        connection.close();
    }
}
