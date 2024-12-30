import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1318Tests {
    private final Solution1318 solution1318 = new Solution1318();

    @Test
    public void example1() {
        int a = 2;
        int b = 6;
        int c = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solution1318.minFlips(a, b, c));
    }

    @Test
    public void example2() {
        int a = 4;
        int b = 2;
        int c = 7;
        int expected = 1;
        Assertions.assertEquals(expected, solution1318.minFlips(a, b, c));
    }

    @Test
    public void example3() {
        int a = 1;
        int b = 2;
        int c = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1318.minFlips(a, b, c));
    }
}
