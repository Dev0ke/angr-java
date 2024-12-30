import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1432Tests {
    private final Solution1432 solution1432 = new Solution1432();

    @Test
    public void example1() {
        int num = 555;
        int expected = 888;
        Assertions.assertEquals(expected, solution1432.maxDiff(num));
    }

    @Test
    public void example2() {
        int num = 9;
        int expected = 8;
        Assertions.assertEquals(expected, solution1432.maxDiff(num));
    }

    @Test
    public void example3() {
        int num = 123456;
        int expected = 820000;
        Assertions.assertEquals(expected, solution1432.maxDiff(num));
    }

    @Test
    public void example4() {
        int num = 10000;
        int expected = 80000;
        Assertions.assertEquals(expected, solution1432.maxDiff(num));
    }

    @Test
    public void example5() {
        int num = 9288;
        int expected = 8700;
        Assertions.assertEquals(expected, solution1432.maxDiff(num));
    }
}