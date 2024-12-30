import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1824Tests {
    private final Solution1824 solution1824 = new Solution1824();

    @Test
    public void example1() {
        int[] obstacles = {0, 1, 2, 3, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution1824.minSideJumps(obstacles));
    }

    @Test
    public void example2() {
        int[] obstacles = {0, 1, 1, 3, 3, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution1824.minSideJumps(obstacles));
    }

    @Test
    public void example3() {
        int[] obstacles = {0, 2, 1, 0, 3, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution1824.minSideJumps(obstacles));
    }
}
