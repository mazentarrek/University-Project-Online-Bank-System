import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest1 {

    @Test
    public void getName1(){
        User test= new User("Nour", "nour123", "01060930799", "nournagah@gmail.com", "a1"
                , 0, 12345678, "a2", 12345687, 0);
        assertEquals("Nour",test.getName());
    }
    @Test
    public void getName2(){
        User test= new User("Ahmed", "nour123", "01060930799", "nournagah@gmail.com", "a1"
                , 0, 12345678, "a2", 12345687, 0);
        assertEquals("Ahmed",test.getName());
    }
    @Test
    public void getName3(){
        User test= new User("Nour", "nour123", "01060930799", "nournagah@gmail.com", "a1"
                , 0, 12345678, "a2", 12345687, 0);
        assertEquals("Nour",test.getName());
    }
}