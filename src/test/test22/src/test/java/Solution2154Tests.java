import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2154Tests {
    private final Solution2154 solution2154 = new Solution2154();

    @Test
    public void example1() {
        int[] nums = {5, 3, 6, 1, 12};
        int original = 3;
        int expected = 24;
        Assertions.assertEquals(expected, solution2154.findFinalValue(nums, original));
    }

    @Test
    public void example2() {
        int[] nums = {2, 7, 9};
        int original = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution2154.findFinalValue(nums, original));
    }
}
