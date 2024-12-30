import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution945Tests {
    private final Solution945 solution945 = new Solution945();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution945.minIncrementForUnique(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1, 2, 1, 7};
        int expected = 6;
        Assertions.assertEquals(expected, solution945.minIncrementForUnique(nums));
    }
}
