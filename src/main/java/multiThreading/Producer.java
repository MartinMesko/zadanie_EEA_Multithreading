package multiThreading;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.DriverManager.getConnection;


public class Producer extends NewUser {

    public static void add(int id, String guid, String name) throws InterruptedException, SQLException {

        Connection spojenie = getConnection(
                "jdbc:mysql://localhost:3306/zadanie_eea",
                "root",
                "2030isNow");
        Statement prikaz = spojenie.createStatement();
        {
            ProducerConsumer_EEA producerQueue = new ProducerConsumer_EEA();
            ProducerConsumer_EEA.queue.add(new NewUser(id, guid, name));
            String prikazInsert = "insert into SUSERS value (" + id + ", " + "'" + guid + "', " + "'" + name + "')";
            prikaz.executeUpdate(prikazInsert);
            System.out.println("USER_ID       USER_GUID        USER_NAME");
            System.out.println("  " + id + "             " + guid + "                " + name);
        }
    }
}
