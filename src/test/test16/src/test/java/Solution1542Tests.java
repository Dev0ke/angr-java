import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1542Tests {
    private final Solution1542 solution1542 = new Solution1542();

    @Test
    public void example1() {
        String s = "3242415";
        int expected = 5;
        Assertions.assertEquals(expected, solution1542.longestAwesome(s));
    }

    @Test
    public void example2() {
        String s = "12345678";
        int expected = 1;
        Assertions.assertEquals(expected, solution1542.longestAwesome(s));
    }

    @Test
    public void example3() {
        String s = "213123";
        int expected = 6;
        Assertions.assertEquals(expected, solution1542.longestAwesome(s));
    }

    @Test
    public void example4() {
        String s = "00";
        int expected = 2;
        Assertions.assertEquals(expected, solution1542.longestAwesome(s));
    }
}
