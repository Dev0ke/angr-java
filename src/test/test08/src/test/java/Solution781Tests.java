import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution781Tests {
    private final Solution781 solution781 = new Solution781();

    @Test
    public void example1() {
        int[] answers = {1, 1, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution781.numRabbits(answers));
    }

    @Test
    public void example2() {
        int[] answers = {10, 10, 10};
        int expected = 11;
        Assertions.assertEquals(expected, solution781.numRabbits(answers));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/396407981/
        int[] answers = {0, 0, 1, 1, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution781.numRabbits(answers));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/396407870/
        int[] answers = {1, 0, 1, 0, 0};
        int expected = 5;
        Assertions.assertEquals(expected, solution781.numRabbits(answers));
    }
}