package E02_GetVillainsNames;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement selectVillains = connection.prepareStatement(
                "SELECT name, COUNT(DISTINCT minion_id) AS number_of_minions FROM villains AS v" +
                        " JOIN minions_villains AS mv ON v.id = mv.villain_id" +
                        " GROUP BY v.name" +
                        " HAVING number_of_minions > 15" +
                        " ORDER BY number_of_minions DESC;"
        );

        ResultSet villainsSet = selectVillains.executeQuery();

        while(villainsSet.next()){
            String name = villainsSet.getString("name");
            int number_of_minions = villainsSet.getInt("number_of_minions");

            System.out.printf("%s %d %n", name, number_of_minions);
        }

        connection.close();
    }
}
