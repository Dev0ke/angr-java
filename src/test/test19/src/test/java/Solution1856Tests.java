import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1856Tests {
    private final Solution1856 solution1856 = new Solution1856();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2};
        int expected = 14;
        Assertions.assertEquals(expected, solution1856.maxSumMinProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 3, 1, 2};
        int expected = 18;
        Assertions.assertEquals(expected, solution1856.maxSumMinProduct(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 1, 5, 6, 4, 2};
        int expected = 60;
        Assertions.assertEquals(expected, solution1856.maxSumMinProduct(nums));
    }
}
