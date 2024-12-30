import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1036Tests {
    private final Solution1036 solution1036 = new Solution1036();

    @Test
    public void example1() {
        int[][] blocked = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int[] source = {0, 0};
        int[] target = {0, 2};
        Assertions.assertFalse(solution1036.isEscapePossible(blocked, source, target));
    }

    @Test
    public void example2() {
        int[][] blocked = UtUtils.stringToInts2("[]");
        int[] source = {0, 0};
        int[] target = {999999, 999999};
        Assertions.assertTrue(solution1036.isEscapePossible(blocked, source, target));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/246094265/
        int[][] blocked = UtUtils.stringToInts2("[[10,9],[9,10],[10,11],[11,10]]");
        int[] source = {0, 0};
        int[] target = {10, 10};
        Assertions.assertFalse(solution1036.isEscapePossible(blocked, source, target));
    }
}