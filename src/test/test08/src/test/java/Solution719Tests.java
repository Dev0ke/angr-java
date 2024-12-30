import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution719Tests {
    private final Solution719 solution719 = new Solution719();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1};
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution719.smallestDistancePair(nums, k));
        Assertions.assertEquals(expected, solution719.smallestDistancePair2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution719.smallestDistancePair(nums, k));
        Assertions.assertEquals(expected, solution719.smallestDistancePair2(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 6, 1};
        int k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution719.smallestDistancePair(nums, k));
        Assertions.assertEquals(expected, solution719.smallestDistancePair2(nums, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/332364957/
        int[] nums = UtUtils.loadingInts("solution719-example4-input.txt", 0);
        int k = UtUtils.loadingInt("solution719-example4-input.txt", 1);
        int expected = 1;
//        Assertions.assertEquals(expected, solution719.smallestDistancePair(nums, k));
        Assertions.assertEquals(expected, solution719.smallestDistancePair2(nums, k));
    }
}
