import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution152Tests {
    private final Solution152 solution152 = new Solution152();

    @Test
    public void example1() {
        int[] nums = {2, 3, -2, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution152.maxProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-2, 0, -1};
        int expected = 0;
        Assertions.assertEquals(expected, solution152.maxProduct(nums));
    }
}
