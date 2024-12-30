import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1764Tests {
    private final Solution1764 solution1764 = new Solution1764();

    @Test
    public void example1() {
        int[][] groups = UtUtils.stringToInts2("[[1,-1,-1],[3,-2,0]]");
        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        Assertions.assertTrue(solution1764.canChoose(groups, nums));
    }

    @Test
    public void example2() {
        int[][] groups = UtUtils.stringToInts2("[[10,-2],[1,2,3,4]]");
        int[] nums = {1, 2, 3, 4, 10, -2};
        Assertions.assertFalse(solution1764.canChoose(groups, nums));
    }

    @Test
    public void example3() {
        int[][] groups = UtUtils.stringToInts2("[[1,2,3],[3,4]]");
        int[] nums = {7, 7, 1, 2, 3, 4, 7, 7};
        Assertions.assertFalse(solution1764.canChoose(groups, nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/389712849/
        // 匹配了半个整数
        int[][] groups = UtUtils.stringToInts2("[[2,1]]");
        int[] nums = {12, 1};
        Assertions.assertFalse(solution1764.canChoose(groups, nums));
    }
}
