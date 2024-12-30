import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution798Tests {
    private final Solution798 solution798 = new Solution798();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 4, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution798.bestRotation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 0, 2, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution798.bestRotation(nums));
    }
}