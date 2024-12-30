import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution372Tests {
    private final Solution372 solution372 = new Solution372();

    @Test
    public void example1() {
        int a = 2;
        int[] b = {3};
        int expected = 8;
        Assertions.assertEquals(expected, solution372.superPow(a, b));
    }

    @Test
    public void example2() {
        int a = 2;
        int[] b = {1, 0};
        int expected = 1024;
        Assertions.assertEquals(expected, solution372.superPow(a, b));
    }

    @Test
    public void example3() {
        int a = 1;
        int[] b = {4, 3, 3, 8, 5, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution372.superPow(a, b));
    }

    @Test
    public void example4() {
        int a = 2147483647;
        int[] b = {2, 0, 0};
        int expected = 1198;
        Assertions.assertEquals(expected, solution372.superPow(a, b));
    }
}
