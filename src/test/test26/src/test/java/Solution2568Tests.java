import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2568Tests {
    private final Solution2568 solution2568 = new Solution2568();

    @Test
    public void example1() {
        int[] nums = {2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution2568.minImpossibleOR(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 3, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution2568.minImpossibleOR(nums));
    }
}