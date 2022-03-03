package E07_PrintAllMinionNames;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement selectMinionNames = connection.prepareStatement(
                "SELECT name FROM minions");
        ResultSet namesSet = selectMinionNames.executeQuery();

        List<String> namesList = new ArrayList<>();

        while(namesSet.next()) {
            namesList.add(namesSet.getString("name"));
        }

        int size = namesList.size();
        int border = size % 2 == 1 ? size / 2 + 1 : size / 2;

        for (int i = 0; i < border; i++) {

            int endIndex = size - 1 - i;

            System.out.println(namesList.get(i));
            if(endIndex != i) {
                System.out.println(namesList.get(endIndex));
            }
        }
    }
}
