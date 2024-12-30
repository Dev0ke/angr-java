import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2357Tests {
    private final Solution2357 solution2357 = new Solution2357();

    @Test
    public void example1() {
        int[] nums = {1, 5, 0, 3, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution2357.minimumOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution2357.minimumOperations(nums));
    }
}
