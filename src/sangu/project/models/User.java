package sangu.project.models;

public class User {

    private String userId;
    private String userName;
    private float userBalance;

    public User(String userId, String userName, float userBalance) {
        this.userId = userId;
        this.userName = userName;
        this.userBalance = userBalance;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(float userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            return userId.equals(((User) o).userId);
        }
        return false;
    }

    @Override
    public String toString() {
        return userId + " - " + userName + " - " + userBalance;
    }
}
