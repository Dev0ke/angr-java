import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1881Tests {
    private final Solution1881 solution1881 = new Solution1881();

    @Test
    public void example1() {
        String n = "99";
        int x = 9;
        String expected = "999";
        Assertions.assertEquals(expected, solution1881.maxValue(n, x));
    }

    @Test
    public void example2() {
        String n = "-13";
        int x = 2;
        String expected = "-123";
        Assertions.assertEquals(expected, solution1881.maxValue(n, x));
    }
}
