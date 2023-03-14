package org.example;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alex", "asda");
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(user1);
        System.out.println(userRepository.findUserByLogin("Alex"));

    }
}