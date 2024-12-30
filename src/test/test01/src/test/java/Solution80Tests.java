import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution80Tests {
    private final Solution80 solution80 = new Solution80();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solution80.removeDuplicates(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int expected = 7;
        Assertions.assertEquals(expected, solution80.removeDuplicates(nums));
    }
}
