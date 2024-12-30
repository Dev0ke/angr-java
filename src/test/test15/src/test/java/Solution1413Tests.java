import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1413Tests {
    private final Solution1413 solution1413 = new Solution1413();

    @Test
    public void example1() {
        int[] nums = {-3, 2, -3, 4, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution1413.minStartValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1413.minStartValue(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, -2, -3};
        int expected = 5;
        Assertions.assertEquals(expected, solution1413.minStartValue(nums));
    }
}
