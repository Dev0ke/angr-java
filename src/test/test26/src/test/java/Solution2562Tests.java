import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2562Tests {
    private final Solution2562 solution2562 = new Solution2562();

    @Test
    public void example1() {
        int[] nums = {7, 52, 2, 4};
        long expected = 596;
        Assertions.assertEquals(expected, solution2562.findTheArrayConcVal(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 14, 13, 8, 12};
        long expected = 673;
        Assertions.assertEquals(expected, solution2562.findTheArrayConcVal(nums));
    }
}