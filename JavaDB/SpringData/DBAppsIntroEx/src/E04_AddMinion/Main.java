package E04_AddMinion;

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

        String minionInput = scanner.nextLine();
        String[] minionData = minionInput.split("\\s+");
        String minionName = minionData[1];
        int minionAge = Integer.parseInt(minionData[2]);
        String townName = minionData[3];

        String villainInput = scanner.nextLine();
        String villainName = villainInput.split("\\s+")[1];

        int townId = getTownId(connection, townName);
        int villainId = getVillainId(connection, villainName);

        insertMinion(connection, minionName, minionAge, townId);
        PreparedStatement selectMinion = connection.prepareStatement(
                "SELECT id FROM minions WHERE name = ?");
        selectMinion.setString(1, minionName);

        ResultSet minionSet = selectMinion.executeQuery();
        minionSet.next();
        int minionId = minionSet.getInt("id");

        appointMinion(connection, minionId, villainId);
        System.out.printf("Successfully added %s to be minion of %s", minionName, villainName);
    }

    private static void appointMinion(Connection connection, int minionId, int villainId) throws SQLException {
        PreparedStatement appointMinion = connection.prepareStatement(
                "INSERT INTO minions_villains(minion_id, villain_id) VALUES (?, ?)");
        appointMinion.setInt(1, minionId);
        appointMinion.setInt(2, villainId);
        appointMinion.executeUpdate();
    }

    private static int getTownId(Connection connection, String name) throws SQLException {
        PreparedStatement selectTown = connection.prepareStatement(
                "SELECT id FROM towns WHERE name = ?");
        selectTown.setString(1, name);

        ResultSet townSet = selectTown.executeQuery();

        if(!townSet.next()) {
            insertTown(connection, name);
        }

        townSet = selectTown.executeQuery();
        townSet.next();
        return townSet.getInt("id");
    }

    private static int getVillainId(Connection connection, String name) throws SQLException {
        PreparedStatement selectVillain = connection.prepareStatement(
                "SELECT id FROM villains WHERE name = ?");
        selectVillain.setString(1, name);

        ResultSet villainSet = selectVillain.executeQuery();

        if(!villainSet.next()) {
            insertVillain(connection, name);
        }

        villainSet = selectVillain.executeQuery();
        villainSet.next();
        return villainSet.getInt("id");
    }

    private static void insertMinion(Connection connection, String minionName, int minionAge, int townId) throws SQLException {
        PreparedStatement insertMinion = connection.prepareStatement(
                "INSERT INTO minions(name, age, town_id) VALUES (?, ?, ?)");
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();
    }

    private static void insertVillain(Connection connection, String villainName) throws SQLException {
        PreparedStatement insertVillain = connection.prepareStatement(
                "INSERT INTO villains(name, evilness_factor) VALUE (?, ?)");
        insertVillain.setString(1, villainName);
        insertVillain.setString(2, "evil");
        insertVillain.executeUpdate();

        System.out.printf("Villain %s was added to the database.%n", villainName);
    }

    private static void insertTown(Connection connection, String townName) throws SQLException {
        PreparedStatement insertTown = connection.prepareStatement(
                "INSERT INTO towns(name) VALUE (?)");
        insertTown.setString(1, townName);
        insertTown.executeUpdate();

        System.out.printf("Town %s was added to the database.%n", townName);
    }
}
