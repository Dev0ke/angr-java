import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2748Tests {
    private final Solution2748 solution2748 = new Solution2748();

    @Test
    public void example1() {
        int[] nums = {2, 5, 1, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution2748.countBeautifulPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {11, 21, 12};
        int expected = 2;
        Assertions.assertEquals(expected, solution2748.countBeautifulPairs(nums));
    }
}