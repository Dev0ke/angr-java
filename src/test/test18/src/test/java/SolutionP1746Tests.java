import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1746Tests {
    private final SolutionP1746 solutionP1746 = new SolutionP1746();

    @Test
    public void example1() {
        int[] nums = {2, -1, -4, -3};
        int expected = 17;
        Assertions.assertEquals(expected, solutionP1746.maxSumAfterOperation(nums));
        Assertions.assertEquals(expected, solutionP1746.maxSumAfterOperation2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, -1, 1, 1, -1, -1, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1746.maxSumAfterOperation(nums));
        Assertions.assertEquals(expected, solutionP1746.maxSumAfterOperation2(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {-4, -49, -12, -75, -48, 46, 72, 10, 51, -51, 26, -74, 70, -1, -25, 29, 27};
        int expected = 5757;
        Assertions.assertEquals(expected, solutionP1746.maxSumAfterOperation(nums));
        Assertions.assertEquals(expected, solutionP1746.maxSumAfterOperation2(nums));
    }
}