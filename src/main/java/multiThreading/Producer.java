package multiThreading;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.DriverManager.getConnection;


public class Producer extends NewUser {

    public static void addUser(int id, String guid, String name) throws InterruptedException, SQLException {

        Connection spojenie = getConnection(
                "jdbc:mysql://localhost:3306/zadanie_eea",
                "root",
                "2030isNow");
        Statement prikaz = spojenie.createStatement();
        {
            ProducerConsumer_EEA producerQueue = new ProducerConsumer_EEA();
            producerQueue.queue.put(new NewUser(id, guid, name));
            String prikazInsert = "insert into SUSERS value (" + id + ", " + "'" + guid + "', " + "'" + name + "')";
            prikaz.executeUpdate(prikazInsert);
        }
    }
}
