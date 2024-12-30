import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3194Tests {
    private final Solution3194 solution3194 = new Solution3194();

    @Test
    public void example1() {
        int[] nums = {7, 8, 3, 4, 15, 13, 4, 1};
        double expected = 5.5;
        Assertions.assertEquals(expected, solution3194.minimumAverage(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 9, 8, 3, 10, 5};
        double expected = 5.5;
        Assertions.assertEquals(expected, solution3194.minimumAverage(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 7, 8, 9};
        double expected = 5.0;
        Assertions.assertEquals(expected, solution3194.minimumAverage(nums));
    }
}