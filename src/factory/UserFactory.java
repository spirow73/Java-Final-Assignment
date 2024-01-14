package factory;

import users.User;

public interface UserFactory {
    User createUser(String id, String name, String email);
}
