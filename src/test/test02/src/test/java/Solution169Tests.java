import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution169Tests {
    private final Solution169 solution169 = new Solution169();

    @Test
    public void example1() {
        int[] nums = {3, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution169.majorityElement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution169.majorityElement(nums));
    }
}
