import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1111Tests {
    private final Solution1111 solution1111 = new Solution1111();

    @Test
    public void example1() {
        String seq = "(()())";
//        int[] expected = {0, 1, 1, 1, 1, 0};
        int[] expected = {1, 0, 0, 0, 0, 1};
        Assertions.assertArrayEquals(expected, solution1111.maxDepthAfterSplit(seq));
    }

    @Test
    public void example2() {
        String seq = "()(())()";
        // 本示例答案不唯一。
//        int[] expected = {0, 0, 0, 1, 1, 0, 1, 1};
        int[] expected = {1, 1, 1, 0, 0, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution1111.maxDepthAfterSplit(seq));
    }
}