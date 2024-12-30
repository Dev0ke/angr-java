import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2616Tests {
    private final Solution2616 solution2616 = new Solution2616();

    @Test
    public void example1() {
        int[] nums = {10, 1, 2, 7, 1, 3};
        int p = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2616.minimizeMax(nums, p));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 1, 2};
        int p = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution2616.minimizeMax(nums, p));
    }
}