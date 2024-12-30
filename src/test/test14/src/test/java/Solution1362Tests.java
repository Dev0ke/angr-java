import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1362Tests {
    private final Solution1362 solution1362 = new Solution1362();

    @Test
    public void example1() {
        int num = 8;
        int[] expected = {3, 3};
        Assertions.assertArrayEquals(expected, solution1362.closestDivisors(num));
    }

    @Test
    public void example2() {
        int num = 123;
        int[] expected = {5, 25};
        Assertions.assertArrayEquals(expected, solution1362.closestDivisors(num));
    }

    @Test
    public void example3() {
        int num = 999;
//        int[] expected = {40, 25};
        int[] expected = {25, 40};
        Assertions.assertArrayEquals(expected, solution1362.closestDivisors(num));
    }
}