package sangu.project.proccessor;

import sangu.project.models.User;

import java.util.List;

public interface Medium {

    void writeUser(User user);
    User getUser(String userId);
    List<User> getUsers();


}
