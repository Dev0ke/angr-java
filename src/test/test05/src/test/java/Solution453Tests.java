import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution453Tests {
    private final Solution453 solution453 = new Solution453();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution453.minMoves(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution453.minMoves(nums));
    }
}
