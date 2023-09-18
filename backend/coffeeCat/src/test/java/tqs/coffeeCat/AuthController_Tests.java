package tqs.coffeeCat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tqs.coffeeCat.controller.AuthController;
import tqs.coffeeCat.payload.request.LoginRequest;
import tqs.coffeeCat.payload.request.RegisterRequest;
import tqs.coffeeCat.service.AuthService;

import tqs.coffeeCat.model.User;

public class AuthController_Tests {

    private static final User User = User("1","username", "email", "password");

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @Ignore
    void testLogin_Success() {
        LoginRequest loginRequest = new LoginRequest("username", "password");

        when(authService.loginUser("username", "password")).thenReturn(User);

        ResponseEntity<?> responseEntity = authController.login(loginRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        assertNotNull(responseBody);
        assertEquals(HttpStatus.OK.value(), responseBody.get("status"));
        assertEquals("username", responseBody.get("username"));
    }

    private static tqs.coffeeCat.model.User User(String string, String string2, String string3, String string4) {
        return null;
    }

    @Ignore
    void testLogin_Failure() {
        LoginRequest loginRequest = new LoginRequest("username", "password");

        when(authService.loginUser("username", "password")).thenThrow(new Exception("Invalid credentials"));

        ResponseEntity<?> responseEntity = authController.login(loginRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());

        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        assertNotNull(responseBody);
        assertEquals(HttpStatus.UNAUTHORIZED.value(), responseBody.get("status"));
        assertEquals("Invalid credentials", responseBody.get("error"));
    }

    @Ignore
    void testRegister_Success() {
        RegisterRequest registerRequest = new RegisterRequest("email", "username", "password");

        ResponseEntity<?> responseEntity = authController.register(registerRequest);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();
        assertNotNull(responseBody);
        assertEquals("Registration successful", responseBody.get("message"));
        assertEquals("username", responseBody.get("username"));
        assertEquals("email", responseBody.get("email"));
    }

    @Ignore
    void testRegister_Conflict() {
        RegisterRequest registerRequest = new RegisterRequest("email", "username", "password");

        when(authService.registerUser("username", "email", "password"))
            .thenThrow(new RuntimeException("User already exists"));

        ResponseEntity<?> responseEntity = authController.register(registerRequest);

        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("User already exists", responseEntity.getBody());
    }
}
