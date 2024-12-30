import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2405Tests {
    private final Solution2405 solution2405 = new Solution2405();

    @Test
    public void example1() {
        String s = "abacaba";
        int expected = 4;
        Assertions.assertEquals(expected, solution2405.partitionString(s));
    }

    @Test
    public void example2() {
        String s = "ssssss";
        int expected = 6;
        Assertions.assertEquals(expected, solution2405.partitionString(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/361521246/
        String s = "hdklqkcssgxlvehva";
        int expected = 4;
        Assertions.assertEquals(expected, solution2405.partitionString(s));
    }
}
