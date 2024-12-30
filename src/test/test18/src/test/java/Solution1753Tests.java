import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1753Tests {
    private final Solution1753 solution1753 = new Solution1753();

    @Test
    public void example1() {
        int a = 2;
        int b = 4;
        int c = 6;
        int expected = 6;
        Assertions.assertEquals(expected, solution1753.maximumScore(a, b, c));
    }

    @Test
    public void example2() {
        int a = 4;
        int b = 4;
        int c = 6;
        int expected = 7;
        Assertions.assertEquals(expected, solution1753.maximumScore(a, b, c));
    }

    @Test
    public void example3() {
        int a = 1;
        int b = 8;
        int c = 8;
        int expected = 8;
        Assertions.assertEquals(expected, solution1753.maximumScore(a, b, c));
    }
}