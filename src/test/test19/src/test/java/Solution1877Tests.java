import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1877Tests {
    private final Solution1877 solution1877 = new Solution1877();

    @Test
    public void example1() {
        int[] nums = {3, 5, 2, 3};
        int expected = 7;
        Assertions.assertEquals(expected, solution1877.minPairSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 5, 4, 2, 4, 6};
        int expected = 8;
        Assertions.assertEquals(expected, solution1877.minPairSum(nums));
    }
}
