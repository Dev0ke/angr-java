import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution731Tests {
    @Test
    public void example1() {
        Solution731.MyCalendarTwo myCalendar = new Solution731.MyCalendarTwo();
        // returns true
        Assertions.assertTrue(myCalendar.book(10, 20));
        // returns true
        Assertions.assertTrue(myCalendar.book(50, 60));
        // returns true
        Assertions.assertTrue(myCalendar.book(10, 40));
        // returns false
        Assertions.assertFalse(myCalendar.book(5, 15));
        // returns true
        Assertions.assertTrue(myCalendar.book(5, 10));
        // returns true
        Assertions.assertTrue(myCalendar.book(25, 55));
    }
}
