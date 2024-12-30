import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3134Tests {
    private final Solution3134 solution3134 = new Solution3134();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution3134.medianOfUniquenessArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 3, 4, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3134.medianOfUniquenessArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 3, 5, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution3134.medianOfUniquenessArray(nums));
    }
}