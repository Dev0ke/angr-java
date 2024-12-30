import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1176Tests {
    private final SolutionP1176 solutionP1176 = new SolutionP1176();

    @Test
    public void example1() {
        int[] calories = {1, 2, 3, 4, 5};
        int k = 1;
        int lower = 3;
        int upper = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1176.dietPlanPerformance(calories, k, lower, upper));
    }

    @Test
    public void example2() {
        int[] calories = {3, 2};
        int k = 2;
        int lower = 0;
        int upper = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1176.dietPlanPerformance(calories, k, lower, upper));
    }

    @Test
    public void example3() {
        int[] calories = {6, 5, 0, 0};
        int k = 2;
        int lower = 1;
        int upper = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1176.dietPlanPerformance(calories, k, lower, upper));
    }
}