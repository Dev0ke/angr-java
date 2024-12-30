import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution238Tests {
    private final Solution238 solution238 = new Solution238();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        Assertions.assertArrayEquals(expected, solution238.productExceptSelf(nums));
    }
}
