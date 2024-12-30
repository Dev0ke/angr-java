import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1000Tests {
    private final Solution1000 solution1000 = new Solution1000();

    @Test
    public void example1() {
        int[] stones = {3, 2, 4, 1};
        int k = 2;
        int expected = 20;
        Assertions.assertEquals(expected, solution1000.mergeStones(stones, k));
    }

    @Test
    public void example2() {
        int[] stones = {3, 2, 4, 1};
        int k = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution1000.mergeStones(stones, k));
    }

    @Test
    public void example3() {
        int[] stones = {3, 5, 1, 2, 6};
        int k = 3;
        int expected = 25;
        Assertions.assertEquals(expected, solution1000.mergeStones(stones, k));
    }
}
