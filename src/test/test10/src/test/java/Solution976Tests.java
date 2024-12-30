import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution976Tests {
    private final Solution976 solution976 = new Solution976();

    @Test
    public void example1() {
        int[] nums = {2, 1, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution976.largestPerimeter(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution976.largestPerimeter(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 3, 4};
        int expected = 10;
        Assertions.assertEquals(expected, solution976.largestPerimeter(nums));
    }

    @Test
    public void example4() {
        int[] nums = {3, 6, 2, 3};
        int expected = 8;
        Assertions.assertEquals(expected, solution976.largestPerimeter(nums));
    }
}
