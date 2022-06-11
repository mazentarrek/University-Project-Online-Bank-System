import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

    UserAccount a ;
    @BeforeEach
    public void init() {
        a = new UserAccount("Nour", 12345678, 2000);
    }

    @Test
    void testGetAmount() {
        assertEquals(2000,a.getAmount());
    }

    @Test
    void setAmount() {
        a.setAmount(3000);
        assertEquals(3000,a.getAmount());
    }

    @Test
    void getName() {
        assertEquals("Nour",a.getName());
    }

    @Test
    void setName() {

        a.setName("Ahmed");
        assertEquals("Ahmed",a.getName());

    }

    @Test
    void getAccountNumber() {
        assertEquals(12345678,a.getSecurityNumber());
    }

    @Test
    void setAccountNumber() {

        a.setSecurityNumber(12345123);
        assertEquals(12345123,a.getSecurityNumber());


    }

    @Test
    void reduceAccount() {

        assertTrue(a.reduceAccount(1000));
        assertFalse(a.reduceAccount(3000));
    }

    @Test
    void increaseAccount() {

        a.increaseAccount(1000);
        assertEquals(3000,a.getAmount());


    }

    @Test
    void transferAccount() {

        UserAccount a2 = new UserAccount("Mazen", 12345432, 10000);

        a.transferAccount(a2, 3000);
        assertEquals(13000, a2.getAmount());

    }
}