import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2216Tests {
    private final Solution2216 solution2216 = new Solution2216();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 3, 5};
        int expected = 1;
        Assertions.assertEquals(expected, solution2216.minDeletion(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 2, 3, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution2216.minDeletion(nums));
    }
}
