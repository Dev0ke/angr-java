import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2208Tests {
    private final Solution2208 solution2208 = new Solution2208();

    @Test
    public void example1() {
        int[] nums = {5, 19, 8, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution2208.halveArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 8, 20};
        int expected = 3;
        Assertions.assertEquals(expected, solution2208.halveArray(nums));
    }
}
