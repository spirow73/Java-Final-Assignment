package factory;

import users.Admin;
import users.User;

public class AdminFactory implements UserFactory {

    @Override
    public User createUser(String id, String name, String email) {
        return new Admin(id, name, email);
    }
}
