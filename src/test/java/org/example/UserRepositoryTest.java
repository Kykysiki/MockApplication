package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class UserRepositoryTest {
    @Test
    @DisplayName("Получение пустого списка пользователей → должен возвращаться пустой список.")
    void gettingAnEmptyListOfUsers() {
        UserRepository userRepositorys = new UserRepository();
        boolean empty = userRepositorys.getAllUsers().isEmpty();
        Assertions.assertTrue(empty);
    }

    @Test
    @DisplayName("Получение списка пользователей при изначально заполненном сервисе → должны возвращаться те же самые пользователи которых добавляли.")
    void gettingAnListOfUsers() {
        UserRepository userRepositorys = new UserRepository();
        User user1 = new User("Alex", "asdad");
        userRepositorys.addUser(user1);
        List<User> expected = userRepositorys.getAllUsers();
        List<User> actual = new ArrayList<User>();
        actual.add(user1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск пользователя по логину → в случае если такой пользователь есть.")
    void findUserByLogin() {
        UserRepository userRepository = new UserRepository();
        User Alex = new User("Alex", "asdas");
        userRepository.addUser(Alex);
        Assertions.assertEquals(Optional.of(Alex), userRepository.findUserByLogin("Alex"));
    }

    @Test
    @DisplayName("Поиск пользователя по логину → в случае когда такого пользователя нет.")
    void findMissingUserByLogin() {
        UserRepository userRepository = new UserRepository();
        User Alex = new User("Alex", "asdas");
        userRepository.addUser(Alex);
        Assertions.assertEquals(Optional.empty(), userRepository.findUserByLogin("Anton"));
    }

    @Test
    @DisplayName("Поиск пользователя по логину и паролю → в случае если такой пользователь есть.")
    void findUserByLoginAndPassword() {
        UserRepository userRepository = new UserRepository();
        User Alex = new User("Alex", "asdas");
        userRepository.addUser(Alex);
        Assertions.assertEquals(Optional.of(Alex), userRepository.findUserByLoginAndPassword("Alex", "asdas"));
    }

    @Test
    @DisplayName("Поиск пользователя по логину и паролю → в случае когда пароль совпадает с одним из существующих, а логин - нет.")
    void findUserByMatchingPassword() {
        UserRepository userRepository = new UserRepository();
        User Alex = new User("Alex", "asdas");
        userRepository.addUser(Alex);
        Assertions.assertEquals(Optional.empty(), userRepository.findUserByLoginAndPassword("Anton", "asdas"));
    }

    @Test
    @DisplayName("Поиск пользователя по логину и паролю - в случае когда логин совпадает с одним из существующих, а пароль - нет.")
    void findUserByMatchingLogin() {
        UserRepository userRepository = new UserRepository();
        User Alex = new User("Alex", "asdas");
        userRepository.addUser(Alex);
        Assertions.assertEquals(Optional.empty(), userRepository.findUserByLoginAndPassword("Alex", "qwerty"));
    }
}