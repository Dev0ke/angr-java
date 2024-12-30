import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1094Tests {
    private final Solution1094 solution1094 = new Solution1094();

    @Test
    public void example1() {
        int[][] trips = UtUtils.stringToInts2("[[2,1,5],[3,3,7]]");
        int capacity = 4;
        Assertions.assertFalse(solution1094.carPooling(trips, capacity));
    }

    @Test
    public void example2() {
        int[][] trips = UtUtils.stringToInts2("[[2,1,5],[3,3,7]]");
        int capacity = 5;
        Assertions.assertTrue(solution1094.carPooling(trips, capacity));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/359493179/
        // RE
        int[][] trips = UtUtils.stringToInts2("[[9,0,1],[3,3,7]]");
        int capacity = 4;
        Assertions.assertFalse(solution1094.carPooling(trips, capacity));
    }
}
