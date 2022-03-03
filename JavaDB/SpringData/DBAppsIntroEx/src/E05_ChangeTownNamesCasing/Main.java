package E05_ChangeTownNamesCasing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        String countryName = scanner.nextLine();

        PreparedStatement updateTowns = connection.prepareStatement(
                "UPDATE towns SET name = UPPER(name) WHERE country = ?");
        updateTowns.setString(1, countryName);

        int updatedTownsCount = updateTowns.executeUpdate();

        PreparedStatement selectTowns = connection.prepareStatement(
                "SELECT name FROM towns WHERE country = ?");
        selectTowns.setString(1, countryName);

        ResultSet townSet = selectTowns.executeQuery();

        if(updatedTownsCount == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        System.out.println(updatedTownsCount + " town names were affected.");

        List<String> resultList = new ArrayList<>();

        while(townSet.next()) {
            resultList.add(townSet.getString("name"));
        }

        System.out.println(resultList);
    }
}
