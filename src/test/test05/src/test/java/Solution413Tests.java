import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution413Tests {
    private final Solution413 solution413 = new Solution413();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution413.numberOfArithmeticSlices(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution413.numberOfArithmeticSlices(nums));
    }
}
