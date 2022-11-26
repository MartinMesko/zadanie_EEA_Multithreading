package multiThreading;

public class NewUser {

    private int userId;
    private String userName, userGuid;

    public NewUser(int userId, String userName, String userGuid) {
        this.userId = userId;
        this.userName = userName;
        this.userGuid = userGuid;
    }
    public NewUser() {

    }
    @Override
    public String toString() {
        return userId +
                "" +
                "" + userName + '\'' +
                "'" + userGuid;
    }
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserGuid() {
        return userGuid;
    }



}
