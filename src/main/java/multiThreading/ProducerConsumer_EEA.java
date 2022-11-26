package multiThreading;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static multiThreading.Consumer.deleteAll;

public class ProducerConsumer_EEA {

    public BlockingQueue<NewUser> queue = new ArrayBlockingQueue<>(2);

    public static void main(String[] args) throws SQLException {

        try(Connection spojenie = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/zadanie_eea",
                    "root",
                    "2030isNow");
                Statement prikaz = spojenie.createStatement()) {
                Thread t1 = new Thread(() -> {
                    try {
                        Producer.add(1, "a1", "Robert");
                        Producer.add(2,"a2", "Martin");

                    } catch (InterruptedException | SQLException e) {
                        throw new RuntimeException(e);
                    }

                });

                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            deleteAll();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                t1.start();
                t2.start();

                t1.join();
                t2.join();

                shutdown();

            String prikazSelect = "select * from SUSERS";
            ResultSet vysledky =  prikaz.executeQuery(prikazSelect);
            while (vysledky.next())
            {
                int userID = vysledky.getInt("USER_ID");
                String userGuid = vysledky.getString("USER_GUID");
                String userName = vysledky.getString("USER_NAME");
                System.out.println("USER_ID       USER_GUID        USER_NAME");
                System.out.println("  " + userID + "             " + userGuid + "                " + userName);
            }

                } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static volatile boolean running = true;
    public static void shutdown() {
        running = false;
    }
}
