import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1906Tests {
    private final Solution1906 solution1906 = new Solution1906();
    private final Solution1906.V2 solution1906_v2 = new Solution1906.V2();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 8};
        int[][] queries = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[0,3]]");
        int[] expected = {2, 1, 4, 1};
        Assertions.assertArrayEquals(expected, solution1906.minDifference(nums, queries));
        Assertions.assertArrayEquals(expected, solution1906_v2.minDifference(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 2, 2, 7, 10};
        int[][] queries = UtUtils.stringToInts2("[[2,3],[0,2],[0,5],[3,5]]");
        int[] expected = {-1, 1, 1, 3};
        Assertions.assertArrayEquals(expected, solution1906.minDifference(nums, queries));
        Assertions.assertArrayEquals(expected, solution1906_v2.minDifference(nums, queries));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/minimum-absolute-difference-queries/submissions/536501166/
        // TLE
        final String fileName = "solution1906-example3-input.txt";
        int[] nums = UtUtils.loadingInts(fileName, 0);
        int[][] queries = UtUtils.loadingInts2(fileName, 1);
        int[] expected = UtUtils.loadingInts("solution1906-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution1906.minDifference(nums, queries));
    }
}