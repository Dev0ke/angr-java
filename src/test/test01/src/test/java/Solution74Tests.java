import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution74Tests {
    private final Solution74 solution74 = new Solution74();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        int target = 3;
        Assertions.assertTrue(solution74.searchMatrix(matrix, target));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        int target = 13;
        Assertions.assertFalse(solution74.searchMatrix(matrix, target));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/224992426/
        int[][] matrix = UtUtils.stringToInts2("[[1]]");
        int target = 2;
        Assertions.assertFalse(solution74.searchMatrix(matrix, target));
    }
}
