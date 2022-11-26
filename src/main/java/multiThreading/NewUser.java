package multiThreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {



    private int userId;
    private String userName, userGuid;

    public Producer(int userId, String userName, String userGuid) {
        this.userId = userId;
        this.userName = userName;
        this.userGuid = userGuid;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public String toString() {
        return "Producer{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userGuid='" + userGuid + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }


}
