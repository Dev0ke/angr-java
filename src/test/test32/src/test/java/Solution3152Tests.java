import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3152Tests {
    private final Solution3152 solution3152 = new Solution3152();

    @Test
    public void example1() {
        int[] nums = {3, 4, 1, 2, 6};
        int[][] queries = UtUtils.stringToInts2("[[0,4]]");
        boolean[] expected = {false};
        Assertions.assertArrayEquals(expected, solution3152.isArraySpecial(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, 1, 6};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[2,3]]");
        boolean[] expected = {false, true};
        Assertions.assertArrayEquals(expected, solution3152.isArraySpecial(nums, queries));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/special-array-ii/submissions/533070222/
        int[] nums = {1};
        int[][] queries = UtUtils.stringToInts2("[[0,0]]");
        boolean[] expected = {true};
        Assertions.assertArrayEquals(expected, solution3152.isArraySpecial(nums, queries));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/problems/special-array-ii/submissions/534112853/
        int[] nums = {1, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,1]]");
        boolean[] expected = {false};
        Assertions.assertArrayEquals(expected, solution3152.isArraySpecial(nums, queries));
    }
}