package multiThreading;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class Consumer implements Runnable{

    public Consumer(int userId, String userName, String userGuid) {
        super();
    }

    public static void deleteAll() throws SQLException, InterruptedException {
        Connection spojenie = getConnection(
                "jdbc:mysql://localhost:3306/zadanie_eea",
                "root",
                "2030isNow");
        Statement prikaz = spojenie.createStatement();
        {
                    ProducerConsumer_EEA producerQueue = new ProducerConsumer_EEA();
                    String prikazDelete = "delete from SUSERS where USER_ID >= 1";
                    prikaz.executeUpdate(prikazDelete);
//                    producerQueue.queue.take();
            NewUser value = producerQueue.queue.take();
            System.out.println("Odobrata hodnota " + value + "; Queue velkost je: " + value);

        }

    }


    @Override
    public void run() {

    }
}
