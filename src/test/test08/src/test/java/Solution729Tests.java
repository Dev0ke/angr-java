import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution729Tests {
    @Test
    public void example1() {
        Solution729.MyCalendar myCalendar = new Solution729.MyCalendar();
        Assertions.assertTrue(myCalendar.book(10, 20));
        Assertions.assertFalse(myCalendar.book(15, 25));
        Assertions.assertTrue(myCalendar.book(20, 30));
    }
}
