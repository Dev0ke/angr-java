import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution503Tests {
    private final Solution503 solution503 = new Solution503();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1};
        int[] expected = {2, -1, 2};
        Assertions.assertArrayEquals(expected, solution503.nextGreaterElements(nums));
    }
}
