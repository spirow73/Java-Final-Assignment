package factory;

import users.Student;
import users.User;

public class StudentFactory implements UserFactory {

    @Override
    public User createUser(String id, String name, String email) {
        return new Student(id, name, email);
    }
}
