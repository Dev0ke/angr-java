import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1040Tests {
    private final Solution1040 solution1040 = new Solution1040();

    @Test
    public void example1() {
        int[] stones = {7, 4, 9};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution1040.numMovesStonesII(stones));
    }

    @Test
    public void example2() {
        int[] stones = {6, 5, 4, 3, 10};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution1040.numMovesStonesII(stones));
    }

    @Test
    public void example3() {
        int[] stones = {100, 101, 104, 102, 103};
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution1040.numMovesStonesII(stones));
    }
}