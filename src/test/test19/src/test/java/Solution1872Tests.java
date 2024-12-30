import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1872Tests {
    private final Solution1872 solution1872 = new Solution1872();

    @Test
    public void example1() {
        int[] stones = {-1, 2, -3, 4, -5};
        int expected = 5;
        Assertions.assertEquals(expected, solution1872.stoneGameVIII(stones));
    }

    @Test
    public void example2() {
        int[] stones = {7, -6, 5, 10, 5, -2, -6};
        int expected = 13;
        Assertions.assertEquals(expected, solution1872.stoneGameVIII(stones));
    }

    @Test
    public void example3() {
        int[] stones = {-10, -12};
        int expected = -22;
        Assertions.assertEquals(expected, solution1872.stoneGameVIII(stones));
    }
}