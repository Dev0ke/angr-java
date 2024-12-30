import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2374Tests {
    private final Solution2374 solution2374 = new Solution2374();

    @Test
    public void example1() {
        int[] edges = {1, 0, 0, 0, 0, 7, 7, 5};
        int expected = 7;
        Assertions.assertEquals(expected, solution2374.edgeScore(edges));
    }

    @Test
    public void example2() {
        int[] edges = {2, 0, 0, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution2374.edgeScore(edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/349932870/
        // 爆 int
        int[] edges = UtUtils.loadingInts("solution2374-example3-input.txt", 0);
        int expected = 1;
        Assertions.assertEquals(expected, solution2374.edgeScore(edges));
    }
}
