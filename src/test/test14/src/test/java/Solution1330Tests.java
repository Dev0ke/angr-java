import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1330Tests {
    private final Solution1330 solution1330 = new Solution1330();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 5, 4};
        int expected = 10;
        Assertions.assertEquals(expected, solution1330.maxValueAfterReverse(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 9, 24, 2, 1, 10};
        int expected = 68;
        Assertions.assertEquals(expected, solution1330.maxValueAfterReverse(nums));
    }
}