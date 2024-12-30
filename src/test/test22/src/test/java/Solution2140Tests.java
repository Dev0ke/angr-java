import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2140Tests {
    private final Solution2140 solution2140 = new Solution2140();

    @Test
    public void example1() {
        int[][] questions = UtUtils.stringToInts2("[[3,2],[4,3],[4,4],[2,5]]");
        long expected = 5;
        Assertions.assertEquals(expected, solution2140.mostPoints(questions));
    }

    @Test
    public void example2() {
        int[][] questions = UtUtils.stringToInts2("[[1,1],[2,2],[3,3],[4,4],[5,5]]");
        long expected = 7;
        Assertions.assertEquals(expected, solution2140.mostPoints(questions));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/258952411/
        // 28 / 54 个通过测试用例
        int[][] questions = UtUtils.stringToInts2("[[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]]");
        long expected = 157;
        Assertions.assertEquals(expected, solution2140.mostPoints(questions));
    }
}
