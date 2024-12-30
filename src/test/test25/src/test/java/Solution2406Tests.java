import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2406Tests {
    private final Solution2406 solution2406 = new Solution2406();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[5,10],[6,8],[1,5],[2,3],[1,10]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2406.minGroups(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[1,3],[5,6],[8,10],[11,13]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2406.minGroups(intervals));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/361772971/
        int[][] intervals = UtUtils.loadingInts2("solution2406-example3-input.txt", 0);
        int expected = 10476;
        Assertions.assertEquals(expected, solution2406.minGroups(intervals));
    }
}
