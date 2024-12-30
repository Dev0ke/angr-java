import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2592Tests {
    private final Solution2592 solution2592 = new Solution2592();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 2, 1, 3, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution2592.maximizeGreatness(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution2592.maximizeGreatness(nums));
    }
}