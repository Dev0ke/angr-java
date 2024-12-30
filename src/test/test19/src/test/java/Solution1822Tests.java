import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1822Tests {
    private final Solution1822 solution1822 = new Solution1822();

    @Test
    public void example1() {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1822.arraySign(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 0, 2, -3};
        int expected = 0;
        Assertions.assertEquals(expected, solution1822.arraySign(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-1, 1, -1, 1, -1};
        int expected = -1;
        Assertions.assertEquals(expected, solution1822.arraySign(nums));
    }
}
