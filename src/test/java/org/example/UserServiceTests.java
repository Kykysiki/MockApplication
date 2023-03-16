package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    public void testAddUserWithNullLogin() {
        String userLogin = null;
        String userPassword = "testPassword";
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.addUser(userLogin, userPassword));
    }

    @Test
    public void testAddUserWithBlankLogin() {
        String userLogin = "";
        String userPassword = "testPassword";
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.addUser(userLogin, userPassword));
    }

    @Test
    public void testAddUserWithNullPassword() {
        String userLogin = "testUser";
        String userPassword = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.addUser(userLogin, userPassword));
    }

    @Test
    public void testAddUserWithBlankPassword() {
        String userLogin = "testUser";
        String userPassword = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.addUser(userLogin, userPassword));
    }
    @Test
    public void testLogin() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);
        userService.addUser("Anton","Anton");

        // Проверяем, что метод возвращает true, когда пользователь существует
        Mockito.lenient().when(userRepository.findUserByLoginAndPassword("Anton", "Anton")).thenReturn(Optional.of(new User("Anton", "Anton")));
        assertTrue(userService.login("Anton", "Anton"));

        // Проверяем, что метод возвращает false, когда пользователь не существует
        Mockito.lenient().when(userRepository.findUserByLoginAndPassword("Alex", "Alex")).thenReturn(Optional.empty());
        assertFalse(userService.login("Alex", "Alex"));
    }
}
