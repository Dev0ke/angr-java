import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2148Tests {
    private final Solution2148 solution2148 = new Solution2148();

    @Test
    public void example1() {
        int[] nums = {11, 7, 2, 15};
        int expected = 2;
        Assertions.assertEquals(expected, solution2148.countElements(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-3, 3, 3, 90};
        int expected = 2;
        Assertions.assertEquals(expected, solution2148.countElements(nums));
    }
}
