import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    Offer o;
    User u;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeEach
    public void init() {
        u = new User("Nour", "nour123", "01060930799", "nournagah@gmail.com", "a1"
                , 0, 12345678, "a2", 12345687, 0);
    }
    @Test
    void getName() { assertEquals("Nour",u.getName());
    }


    @Test
    void setName() { u.setName("Mazen");
        assertEquals("Mazen",u.Name);
    }

    @Test
    void getPassword() {
        assertEquals("nour123",u.getPassword());
    }

    @Test
    void setPassword() {
        u.setPassword("mazen123");
        assertEquals("mazen123",u.Password);
    }

    @Test
    void getPhoneNumber() {
        assertEquals("01060930799",u.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {

        u.setPhoneNumber("01001463687");
        assertEquals("01001463687",u.PhoneNumber);
    }

    @Test
    void getAddress() {
            assertEquals("nournagah@gmail.com", u.EmailAddress);
    }

    @Test
    void setAddress() {
        u.setAddress("mazen@gmail.com");
        assertEquals("mazen@gmail.com",u.EmailAddress);
    }

    @Test
    void seeMyAccountAmount() {
        assertEquals(0,u.a1.amount);
        assertEquals(0,u.a1.getAmount());
        assertEquals(0,u.SeeMyAccountAmount(u.a1));
    }

    @Test
    void addMoneyToMyAccount() {
        u.a2.increaseAccount(100);
        assertEquals(100, u.a2.amount);
        assertEquals(100, u.a2.getAmount());
        assertEquals(100, u.SeeMyAccountAmount(u.a2));
    }

    @Test
    void buyCertificates() {
        u.a1.increaseAccount(50);
        assertTrue(u.buyCertificates(u,"Sadat",20));
        System.out.println(u.a1.amount);
        assertFalse(u.buyCertificates(u,"Talaat Harb",2000));
    }

    @Test
    void withdraw1() {
        u.a1.increaseAccount(30);
        assertTrue(u.withdraw1(10));
    }

    @Test
    void withdraw2() {
        u.a2.increaseAccount(30);
        assertFalse(u.withdraw1(60));
    }

    @Test
    void payBills() {

        u.a1.increaseAccount(50);
        assertTrue(u.PayBills(u,"Water Bill",20));
        System.out.println(u.a1.amount);
        assertFalse(u.buyCertificates(u,"Electricity Bill",2000));


    }
}