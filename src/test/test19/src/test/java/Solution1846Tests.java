import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1846Tests {
    private final Solution1846 solution1846 = new Solution1846();

    @Test
    public void example1() {
        int[] arr = {2, 2, 1, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution1846.maximumElementAfterDecrementingAndRearranging(arr));
    }

    @Test
    public void example2() {
        int[] arr = {100, 1, 1000};
        int expected = 3;
        Assertions.assertEquals(expected, solution1846.maximumElementAfterDecrementingAndRearranging(arr));
    }

    @Test
    public void example3() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution1846.maximumElementAfterDecrementingAndRearranging(arr));
    }
}