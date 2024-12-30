import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1049Tests {
    private final Solution1049 solution1049 = new Solution1049();

    @Test
    public void example1() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1049.lastStoneWeightII(stones));
        Assertions.assertEquals(expected, solution1049.lastStoneWeightII2(stones));
    }

    @Test
    public void example2() {
        int[] stones = {31, 26, 33, 21, 40};
        int expected = 5;
        Assertions.assertEquals(expected, solution1049.lastStoneWeightII(stones));
        Assertions.assertEquals(expected, solution1049.lastStoneWeightII2(stones));
    }

    @Test
    public void example3() {
        int[] stones = {1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1049.lastStoneWeightII(stones));
        Assertions.assertEquals(expected, solution1049.lastStoneWeightII2(stones));
    }
}
