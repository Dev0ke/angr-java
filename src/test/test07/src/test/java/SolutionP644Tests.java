import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP644Tests {
    private final SolutionP644 solutionP644 = new SolutionP644();

    @Test
    public void example1() {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double expected = 12.75000;
        Assertions.assertEquals(expected, solutionP644.findMaxAverage(nums, k), 1e-5);
    }

    @Test
    public void example2() {
        int[] nums = {5};
        int k = 1;
        double expected = 5.00000;
        Assertions.assertEquals(expected, solutionP644.findMaxAverage(nums, k), 1e-5);
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {0, 0, 3, 2, 4};
        int k = 5;
        double expected = 1.80000;
        Assertions.assertEquals(expected, solutionP644.findMaxAverage(nums, k), 1e-5);
    }
}