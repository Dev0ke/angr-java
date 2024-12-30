import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1013Tests {
    private final Solution1013 solution1013 = new Solution1013();

    @Test
    public void example1() {
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        Assertions.assertTrue(solution1013.canThreePartsEqualSum(arr));
    }

    @Test
    public void example2() {
        int[] arr = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        Assertions.assertFalse(solution1013.canThreePartsEqualSum(arr));
    }

    @Test
    public void example3() {
        int[] arr = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        Assertions.assertTrue(solution1013.canThreePartsEqualSum(arr));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/361451954/
        int[] arr = {6, 1, 1, 13, -1, 0, -10, 20};
        Assertions.assertFalse(solution1013.canThreePartsEqualSum(arr));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/361453949/
        int[] arr = {1, -1, 1, -1};
        Assertions.assertFalse(solution1013.canThreePartsEqualSum(arr));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/361454167/
        int[] arr = {0, 0, 0, 0};
        Assertions.assertTrue(solution1013.canThreePartsEqualSum(arr));
    }
}