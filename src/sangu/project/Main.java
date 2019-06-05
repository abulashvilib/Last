package sangu.project;

import sangu.project.models.User;

public class Main {

    public static void main(String[] args) {
        Core core = new Core();
        User user = core.getUser("04DF018B");
        User user2 = core.getUser("04E0018C");
        System.out.println(user);
        System.out.println(user2);
        core.transferAmount(user2, user, 10);
        System.out.println(user);
        System.out.println(user2);
    }

}
