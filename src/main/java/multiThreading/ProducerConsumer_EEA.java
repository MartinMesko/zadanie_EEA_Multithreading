package multiThreading;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumer_EEA {

    public static BlockingQueue<NewUser> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws SQLException {


        try (Connection spojenie = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/zadanie_eea",
                "root",
                "2030isNow");
             Statement prikaz = spojenie.createStatement()) {
            Thread t1 = new Thread(() -> {
                try {
                    Producer.add(1, "a1", "Robert");
                    Thread.sleep(1000);
                    Producer.add(2, "a2", "Martin");

                } catch (InterruptedException | SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            Thread t2 = new Thread(() -> {
                try {

                    Thread.sleep(1000);
                    consumer();
                    ProducerConsumer_EEA.queue.take();
                    if (queue.size() > 0)
                    {
                        ProducerConsumer_EEA.queue.take();
                    }

                } catch (SQLException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            System.out.println("Počet je : " + queue.size());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void consumer() throws SQLException {
        Connection spojenie = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/zadanie_eea",
                "root",
                "2030isNow");
        Statement prikaz = spojenie.createStatement();

            try {
                Thread.sleep(100);
                String prikazDelete = "delete from SUSERS where USER_ID >= 1";
                prikaz.executeUpdate(prikazDelete);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}

