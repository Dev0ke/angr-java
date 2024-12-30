import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2702Tests {
    private final SolutionP2702 solutionP2702 = new SolutionP2702();

    @Test
    public void example1() {
        int[] nums = {3, 4, 1, 7, 6};
        int x = 4;
        int y = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2702.minOperations(nums, x, y));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1};
        int x = 2;
        int y = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2702.minOperations(nums, x, y));
    }
}