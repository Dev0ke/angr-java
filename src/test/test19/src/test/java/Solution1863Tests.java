import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1863Tests {
    private final Solution1863 solution1863 = new Solution1863();

    @Test
    public void example1() {
        int[] nums = {1, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solution1863.subsetXORSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 1, 6};
        int expected = 28;
        Assertions.assertEquals(expected, solution1863.subsetXORSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 4, 5, 6, 7, 8};
        int expected = 480;
        Assertions.assertEquals(expected, solution1863.subsetXORSum(nums));
    }
}
