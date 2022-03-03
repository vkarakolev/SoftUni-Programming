package E08_IncreaseMinionsAge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "2342");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", props);

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int[] ids = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            ids[i] = Integer.parseInt(input[i]);
        }

        PreparedStatement updateMinions = connection.prepareStatement(
                "UPDATE minions SET name = LOWER(name), age = age + 1 WHERE id IN (?)");

    }
}
