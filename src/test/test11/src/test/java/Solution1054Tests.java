import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1054Tests {
    private final Solution1054 solution1054 = new Solution1054();

    @Test
    public void example1() {
        int[] barcodes = {1, 1, 1, 2, 2, 2};
        // 答案不唯一
//        int[] expected = {2, 1, 2, 1, 2, 1};
        int[] expected = {1, 2, 1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, solution1054.rearrangeBarcodes(barcodes));
    }

    @Test
    public void example2() {
        int[] barcodes = {1, 1, 1, 1, 2, 2, 3, 3};
        // 答案不唯一
//        int[] expected = {1, 3, 1, 3, 2, 1, 2, 1};
        int[] expected = {1, 2, 1, 3, 1, 2, 1, 3};
        Assertions.assertArrayEquals(expected, solution1054.rearrangeBarcodes(barcodes));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/432265177/ WA
        int[] barcodes = {1};
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution1054.rearrangeBarcodes(barcodes));
    }
}