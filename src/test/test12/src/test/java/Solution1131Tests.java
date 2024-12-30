import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1131Tests {
    private final Solution1131 solution1131 = new Solution1131();

    @Test
    public void example1() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {-1, 4, 5, 6};
        int expected = 13;
        Assertions.assertEquals(expected, solution1131.maxAbsValExpr(arr1, arr2));
        Assertions.assertEquals(expected, solution1131.maxAbsValExpr2(arr1, arr2));
    }

    @Test
    public void example2() {
        int[] arr1 = {1, -2, -5, 0, 10};
        int[] arr2 = {0, -2, -1, -7, -4};
        int expected = 20;
        Assertions.assertEquals(expected, solution1131.maxAbsValExpr(arr1, arr2));
        Assertions.assertEquals(expected, solution1131.maxAbsValExpr2(arr1, arr2));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/maximum-of-absolute-value-expression/submissions/539825557
        // TLE
        final String fileName = "solution1131-example3-input.txt";
        int[] arr1 = UtUtils.loadingInts(fileName, 0);
        int[] arr2 = UtUtils.loadingInts(fileName, 1);
        int expected = 4005559;
//        Assertions.assertEquals(expected, solution1131.maxAbsValExpr(arr1, arr2));
        Assertions.assertEquals(expected, solution1131.maxAbsValExpr2(arr1, arr2));
    }
}