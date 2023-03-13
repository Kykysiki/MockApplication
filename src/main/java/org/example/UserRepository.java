package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
    }

    public Optional<User> findUserByLogin(String login) {
        Optional<User> user = Optional.empty();
        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            String currentLogin = currentUser.getLogin();
            if (login.equals(currentLogin)) {
                user = Optional.of(currentUser);
                return user;
            }
        }
        return user;
    }

    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        Optional<User> user = Optional.empty();
        for (int i = 0; i < users.size(); i++) {
            User currentUser = users.get(i);
            String currentLogin = currentUser.getLogin();
            String currentPassword = currentUser.getPassword();
            if (login.equals(currentLogin) && password.equals(currentPassword)) {
                user = Optional.of(currentUser);
                return user;
            }
        }
        return user;
    }


    public List<User> getAllUsers() {
        return users;
    }
}
