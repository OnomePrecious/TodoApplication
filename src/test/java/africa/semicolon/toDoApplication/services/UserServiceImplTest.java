package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.data.repository.UserRepository;
import africa.semicolon.toDoApplication.dto.LogInRequest;
import africa.semicolon.toDoApplication.dto.RegisterRequest;
import africa.semicolon.toDoApplication.exception.UnableToLogInException;
import africa.semicolon.toDoApplication.exception.UsernameAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();

    }

    @Test
    public void testThatICan_register() {
        RegisterRequest request = new RegisterRequest();

        request.setUsername("Precious");
        request.setPassword("Oghenebukowho");
        request.setEmail("precious@gmail.com");

        userService.register(request);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void testThatICan_registerTwoUsers() {
        RegisterRequest request = new RegisterRequest();

        RegisterRequest secondRequest = new RegisterRequest();
        request.setEmail("rachel@gmail.com");
        request.setPassword("elohor");
        request.setUsername("presh");

        secondRequest.setEmail("tega@gmail.com");
        secondRequest.setPassword("coutinho");
        secondRequest.setUsername("Paul");


        userService.register(request);
        userService.register(secondRequest);

        assertEquals(2, userRepository.count());


    }

    @Test
    public void logIn() {
        RegisterRequest request = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();

        request.setUsername("Precious");
        request.setPassword("Oghenebukowho");
        request.setEmail("precious@gmail.com");

        logInRequest.setUsername("Precious");
        logInRequest.setPassword("Oghenebukowho");

        userService.register(request);
        userService.logIn(logInRequest);

        assertEquals(1, userRepository.count());


    }

    @Test
    public void logOut() {
        RegisterRequest request = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();

        request.setUsername("Precious");
        request.setPassword("Oghenebukowho");
        request.setEmail("precious@gmail.com");

        logInRequest.setUsername("Precious");
        logInRequest.setPassword("Oghenebukowho");

        userService.register(request);
        userService.logIn(logInRequest);
        userService.logOut(logInRequest);

        assertFalse(userRepository.findUserByUsername(logInRequest.getUsername()).isLoggedIn());


    }

    @Test
    public void test_throwsUsernameAlreadyExistExceptionWhenITryToRegisterWithAnExistingUsername() {
        RegisterRequest request = new RegisterRequest();

        RegisterRequest secondRequest = new RegisterRequest();
        request.setEmail("rachel@gmail.com");
        request.setPassword("elohor");
        request.setUsername("presh");

        secondRequest.setEmail("tega@gmail.com");
        secondRequest.setPassword("coutinho");
        secondRequest.setUsername("presh");


        userService.register(request);
        assertThrows(UsernameAlreadyExistException.class, () -> userService.register(secondRequest));
    }
@Test
    public void test_throwsExceptionWhenITryToLogInWithIncorrectPassword(){
    RegisterRequest request = new RegisterRequest();
    LogInRequest logInRequest = new LogInRequest();

    request.setUsername("Precious");
    request.setPassword("Oghenebukowho");
    request.setEmail("precious@gmail.com");

    logInRequest.setUsername("Precious");
    logInRequest.setPassword("presh");

    userService.register(request);


    assertThrows(UnableToLogInException.class,() -> userService.logIn(logInRequest));

}
}

