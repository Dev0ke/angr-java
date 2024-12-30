import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1736Tests {
    private final Solution1736 solution1736 = new Solution1736();

    @Test
    public void example1() {
        String time = "2?:?0";
        String expected = "23:50";
        Assertions.assertEquals(expected, solution1736.maximumTime(time));
    }

    @Test
    public void example2() {
        String time = "0?:3?";
        String expected = "09:39";
        Assertions.assertEquals(expected, solution1736.maximumTime(time));
    }

    @Test
    public void example3() {
        String time = "1?:22";
        String expected = "19:22";
        Assertions.assertEquals(expected, solution1736.maximumTime(time));
    }
}