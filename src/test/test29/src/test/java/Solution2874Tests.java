import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2874Tests {
    private final Solution2874 solution2874 = new Solution2874();

    @Test
    public void example1() {
        int[] nums = {12, 6, 1, 2, 7};
        long expected = 77;
        Assertions.assertEquals(expected, solution2874.maximumTripletValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 3, 4, 19};
        long expected = 133;
        Assertions.assertEquals(expected, solution2874.maximumTripletValue(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        long expected = 0;
        Assertions.assertEquals(expected, solution2874.maximumTripletValue(nums));
    }
}