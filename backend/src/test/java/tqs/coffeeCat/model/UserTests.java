package tqs.coffeeCat;

import tqs.coffeeCat.model.User;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserTests {

    @Test
    public void testCreateUserWithAllFields() {
        User user = new User("1", "username", "email@example.com", "password");
        assertEquals("1", user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("email@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testCreateUserWithoutId() {
        User user = new User("username", "email@example.com", "password");
        assertNull(user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("email@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testToString() {
        User user = new User("1", "username", "email@example.com", "password");
        String expectedString = "{" +
                " id='1', username='username'" +
                ", email='email@example.com', password='password'" +
                "}";
        assertEquals(expectedString, user.toString());
    }

    // Adicione mais testes conforme necessário
}
