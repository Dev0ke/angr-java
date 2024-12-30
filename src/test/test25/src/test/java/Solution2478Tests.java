import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2478Tests {
    private final Solution2478 solution2478 = new Solution2478();

    @Test
    public void example1() {
        String s = "23542185131";
        int k = 3;
        int minLength = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2478.beautifulPartitions(s, k, minLength));
    }

    @Test
    public void example2() {
        String s = "23542185131";
        int k = 3;
        int minLength = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution2478.beautifulPartitions(s, k, minLength));
    }

    @Test
    public void example3() {
        String s = "3312958";
        int k = 3;
        int minLength = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution2478.beautifulPartitions(s, k, minLength));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/383451642/
        // 组合数公式失效
        String s = "783938233588472343879134266968";
        int k = 4;
        int minLength = 6;
        int expected = 4;
        Assertions.assertEquals(expected, solution2478.beautifulPartitions(s, k, minLength));
    }
}