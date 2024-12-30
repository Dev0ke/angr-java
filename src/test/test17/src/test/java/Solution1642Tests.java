import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1642Tests {
    private final Solution1642 solution1642 = new Solution1642();

    @Test
    public void example1() {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution1642.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void example2() {
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10;
        int ladders = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution1642.furthestBuilding(heights, bricks, ladders));
    }

    @Test
    public void example3() {
        int[] heights = {14, 3, 19, 3};
        int bricks = 17;
        int ladders = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution1642.furthestBuilding(heights, bricks, ladders));
    }
}
