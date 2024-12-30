import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2742Tests {
    private final Solution2742 solution2742 = new Solution2742();

    @Test
    public void example1() {
        int[] cost = {1, 2, 3, 2};
        int[] time = {1, 2, 3, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution2742.paintWalls(cost, time));
    }

    @Test
    public void example2() {
        int[] cost = {2, 3, 4, 2};
        int[] time = {1, 1, 1, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution2742.paintWalls(cost, time));
    }

    // 补充用例
    @Test
    public void example3() {
        // 贪心的反例
        int[] cost = {76, 25, 96, 46, 85, 19, 29, 88, 2, 5};
        int[] time = {1, 2, 1, 3, 1, 3, 3, 3, 2, 1};
        int expected = 46;
        Assertions.assertEquals(expected, solution2742.paintWalls(cost, time));
    }

    @Test
    public void example4() {
        // 0-1 背包 j - wi - 1 >= 0
        int[] cost = {8, 7, 5, 15};
        int[] time = {1, 1, 2, 1};
        int expected = 12;
        Assertions.assertEquals(expected, solution2742.paintWalls(cost, time));
    }
}