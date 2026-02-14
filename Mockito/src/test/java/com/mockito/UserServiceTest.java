package com.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mockito.User;
import mockito.UserDao;
import mockito.UserService;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnNewUserWhenBalanceIsLow() {
        // Arrange
        User user = new User();
        user.setId(2);
        user.setName("Miller");
        user.setBalance(1000);

        when(userDao.findById(2)).thenReturn(user);

        // Act
        String result = userService.typeOfUser(2);

        // Assert
        assertEquals("new user", result);
    }
}
