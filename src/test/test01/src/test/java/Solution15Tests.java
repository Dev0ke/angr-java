import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution15Tests {
    private final Solution15 solution15 = new Solution15();

    @Test
    public void example1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[-1,-1,2],[-1,0,1]]");
        Assertions.assertEquals(expected, solution15.threeSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution15.threeSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution15.threeSum(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/322391381/
        // 86 / 318 个通过测试用例 注意去重
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,0,0]]");
        Assertions.assertEquals(expected, solution15.threeSum(nums));
    }
}
