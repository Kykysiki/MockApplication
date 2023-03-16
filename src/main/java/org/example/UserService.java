package org.example;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = new UserRepository();
        addUser("Test1", "Test1");
        addUser("Test2", "Test2");
    }

    public void addUser(String userLogin, String userPassword) {
        User user = new User(userLogin, userPassword);

        if (userLogin == null || userLogin.isBlank()) {
            throw new IllegalArgumentException("User login should be defined");
        }
        if (userPassword == null || userPassword.isBlank()) {
            throw new IllegalArgumentException("User password should be defined");
        }

        boolean userExist = this.userRepository.getAllUsers().stream().anyMatch(t -> t.equals(user));

        if (userExist) {
            throw new UserNonUniqueException("User already exist", userLogin);
        }
        this.userRepository.addUser(user);
    }

    public boolean login(String userLogin, String userPassword) {
        Optional<User> user = userRepository.findUserByLoginAndPassword(userLogin, userPassword);
        return user.isPresent();
    }
}
