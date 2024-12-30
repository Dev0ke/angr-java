import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution813Tests {
    private final Solution813 solution813 = new Solution813();

    @Test
    public void example1() {
        int[] nums = {9, 1, 2, 3, 9};
        int k = 3;
        double expected = 20.00000;
        Assertions.assertEquals(expected, solution813.largestSumOfAverages(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;
        double expected = 20.50000;
        Assertions.assertEquals(expected, solution813.largestSumOfAverages(nums, k));
    }
}
