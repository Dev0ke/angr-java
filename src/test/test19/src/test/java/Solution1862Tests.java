import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1862Tests {
    private final Solution1862 solution1862 = new Solution1862();

    @Test
    public void example1() {
        int[] nums = {2, 5, 9};
        int expected = 10;
        Assertions.assertEquals(expected, solution1862.sumOfFlooredPairs(nums));
        Assertions.assertEquals(expected, solution1862.sumOfFlooredPairs2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        int expected = 49;
        Assertions.assertEquals(expected, solution1862.sumOfFlooredPairs(nums));
        Assertions.assertEquals(expected, solution1862.sumOfFlooredPairs2(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = UtUtils.loadingInts("solution1862-example3-input.txt", 0);
        int expected = 703074513;
        Assertions.assertEquals(expected, solution1862.sumOfFlooredPairs(nums));
//        Assertions.assertEquals(expected, solution1862.sumOfFlooredPairs2(nums));
    }
}
