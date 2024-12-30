import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution493Tests {
    private final Solution493 solution493 = new Solution493();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 3, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution493.reversePairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 3, 5, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution493.reversePairs(nums));
    }
}