import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3231Tests {
    private final SolutionP3231.V1 solutionP3231_v1 = new SolutionP3231.V1();
    private final SolutionP3231.V2 solutionP3231_v2 = new SolutionP3231.V2();

    @Test
    public void example1() {
        int[] nums = {5, 3, 1, 4, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3231_v1.minOperations(nums));
        Assertions.assertEquals(expected, solutionP3231_v2.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3231_v1.minOperations(nums));
        Assertions.assertEquals(expected, solutionP3231_v2.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 4, 3, 2, 1};
        int expected = 5;
        Assertions.assertEquals(expected, solutionP3231_v1.minOperations(nums));
        Assertions.assertEquals(expected, solutionP3231_v2.minOperations(nums));
    }
}