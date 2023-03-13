package org.example;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserService();
//        userService.addUser("Test1","123");
//        userService.addUser("Gleb","1234");
        User user1 = new User("Dsda", "asda");
        User user2 = new User("Dsasa", "asda");
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        System.out.println(userRepository.findUserByLogin("Dsd"));
        System.out.println(userRepository.getAllUsers());

    }
}