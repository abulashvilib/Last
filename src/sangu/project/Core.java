package sangu.project;

import sangu.project.models.User;
import sangu.project.proccessor.Processor;

public class Core {

    private Processor processor;

    Core() {
        processor = new Processor();
    }

    public void addAmount(User user, float amount) {
        user.setUserBalance(user.getUserBalance() + amount);
        processor.writeUser(user);
    }

    public void removeAmount(User user, float amount) {
        user.setUserBalance(user.getUserBalance() - amount);
        processor.writeUser(user);
    }

    public void transferAmount(User fromUser, User toUser, float amount) {
        if (fromUser.getUserBalance() >= amount) {
            removeAmount(fromUser, amount);
            addAmount(toUser, amount);
        } else {
            System.out.println("Not enough amount to transfer");
        }
    }

    public User getUser(String userId) {
        return processor.getUser(userId);
    }

}
