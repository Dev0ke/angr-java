import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution217Tests {
    private final Solution217 solution217 = new Solution217();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1};
        Assertions.assertTrue(solution217.containsDuplicate(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(solution217.containsDuplicate(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        Assertions.assertTrue(solution217.containsDuplicate(nums));
    }
}
