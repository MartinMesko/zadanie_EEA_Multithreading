package multiThreading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws SQLException {

        BlockingQueue<NewUser> queue = new ArrayBlockingQueue<>(2);

        Connection spojenie = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/zadanie_eea",
                "root",
                "2030isNow");
        Statement prikaz = spojenie.createStatement();
    }
}