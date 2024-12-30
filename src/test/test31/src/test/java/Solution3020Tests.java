import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3020Tests {
    private final Solution3020 solution3020 = new Solution3020();

    @Test
    public void example1() {
        int[] nums = {5, 4, 1, 2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution3020.maximumLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 2, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3020.maximumLength(nums));
    }
}