import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1488Tests {
    private final Solution1488 solution1488 = new Solution1488();

    @Test
    public void example1() {
        int[] rains = {1, 2, 3, 4};
        int[] expected = {-1, -1, -1, -1};
        Assertions.assertArrayEquals(expected, solution1488.avoidFlood(rains));
    }

    @Test
    public void example2() {
        int[] rains = {1, 2, 0, 0, 2, 1};
        int[] expected = {-1, -1, 2, 1, -1, -1};
        Assertions.assertArrayEquals(expected, solution1488.avoidFlood(rains));
    }

    @Test
    public void example3() {
        int[] rains = {1, 2, 0, 1, 2};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution1488.avoidFlood(rains));
    }
}