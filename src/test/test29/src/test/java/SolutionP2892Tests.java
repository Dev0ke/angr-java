import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2892Tests {
    private final SolutionP2892 solutionP2892 = new SolutionP2892();

    @Test
    public void example1() {
        int[] nums = {2, 3, 3, 7, 3, 5};
        int k = 20;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2892.minArrayLength(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 3, 3};
        int k = 6;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2892.minArrayLength(nums, k));
    }
}