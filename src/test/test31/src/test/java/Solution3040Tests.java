import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3040Tests {
    private final Solution3040 solution3040 = new Solution3040();

    @Test
    public void example1() {
        int[] nums = {3, 2, 1, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution3040.maxOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 6, 1, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution3040.maxOperations(nums));
    }
}