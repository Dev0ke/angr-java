import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution312Tests {
    private final Solution312 solution312 = new Solution312();

    @Test
    public void example1() {
        int[] nums = {3, 1, 5, 8};
        int expected = 167;
        Assertions.assertEquals(expected, solution312.maxCoins(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5};
        int expected = 10;
        Assertions.assertEquals(expected, solution312.maxCoins(nums));
    }
}
