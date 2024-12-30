import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution896Tests {
    private final Solution896 solution896 = new Solution896();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3};
        Assertions.assertTrue(solution896.isMonotonic(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 5, 4, 4};
        Assertions.assertTrue(solution896.isMonotonic(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 2};
        Assertions.assertFalse(solution896.isMonotonic(nums));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 4, 5};
        Assertions.assertTrue(solution896.isMonotonic(nums));
    }

    @Test
    public void example5() {
        int[] nums = {1, 1, 1};
        Assertions.assertTrue(solution896.isMonotonic(nums));
    }
}
