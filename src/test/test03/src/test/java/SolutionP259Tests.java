import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP259Tests {
    private final SolutionP259 solutionP259 = new SolutionP259();

    @Test
    public void example1() {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP259.threeSumSmaller(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {};
        int target = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP259.threeSumSmaller(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int target = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP259.threeSumSmaller(nums, target));
    }
}
