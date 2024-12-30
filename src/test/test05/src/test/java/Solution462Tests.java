import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution462Tests {
    private final Solution462 solution462 = new Solution462();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution462.minMoves2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 2, 9};
        int expected = 16;
        Assertions.assertEquals(expected, solution462.minMoves2(nums));
    }
}
