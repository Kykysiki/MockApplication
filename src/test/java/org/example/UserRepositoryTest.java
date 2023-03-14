package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserRepositoryTest {

    @Test
    @DisplayName ("Поиск пользователя по логину → в случае если такой пользователь есть.")
    void findUserByLogin() {
        User Alex = new User("Alex","asdas");
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(Alex);
        userRepository.findUserByLogin("Alex");

    }

    @Test
    void findUserByLoginAndPassword() {
    }

    @Test
    @DisplayName ("Получение пустого списка пользователей → должен возвращаться пустой список.")
    void GettingAnEmptyListOfUsers() {
        List<User> users = new ArrayList<>();
        boolean empty = users.isEmpty();
        Assertions.assertTrue(empty);

    }
    @Test
    @DisplayName ("Получение списка пользователей при изначально заполненном сервисе → должны возвращаться те же самые пользователи которых добавляли.")
    void getAllUsers() {
        List<User> users = new ArrayList<>();
        User Alex = new User("Alex","asdas");
        User Poly = new User("Poly","zxcc");
        users.add(Alex);
        users.add(Poly);
    }
}