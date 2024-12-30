import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2519Tests {
    private final SolutionP2519 solutionP2519 = new SolutionP2519();

    @Test
    public void example1() {
        int[] nums = {2, 3, 6, 5, 2, 3};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2519.kBigIndices(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2519.kBigIndices(nums, k));
    }
}