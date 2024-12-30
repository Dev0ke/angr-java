import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1043Tests {
    private final Solution1043 solution1043 = new Solution1043();

    @Test
    public void example1() {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int expected = 84;
        Assertions.assertEquals(expected, solution1043.maxSumAfterPartitioning(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k = 4;
        int expected = 83;
        Assertions.assertEquals(expected, solution1043.maxSumAfterPartitioning(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {1};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1043.maxSumAfterPartitioning(arr, k));
    }
}