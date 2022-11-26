package multiThreading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
                        Producer.addUser(1, "a1", "Robert");
                        Producer.addUser(2,"a2", "Martin");

                    } catch (InterruptedException | SQLException e) {
                        throw new RuntimeException(e);
                    }

                });
                t1.start();
                }

            }

    }
