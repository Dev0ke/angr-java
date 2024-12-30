import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1690Tests {
    private final Solution1690 solution1690 = new Solution1690();

    @Test
    public void example1() {
        int[] stones = {5, 3, 1, 4, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution1690.stoneGameVII(stones));
    }

    @Test
    public void example2() {
        int[] stones = {7, 90, 5, 1, 100, 10, 10, 2};
        int expected = 122;
        Assertions.assertEquals(expected, solution1690.stoneGameVII(stones));
    }
}