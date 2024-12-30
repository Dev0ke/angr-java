import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2393Tests {
    private final SolutionP2393 solutionP2393 = new SolutionP2393();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 4, 4, 6};
        long expected = 10;
        Assertions.assertEquals(expected, solutionP2393.countSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        long expected = 15;
        Assertions.assertEquals(expected, solutionP2393.countSubarrays(nums));
    }
}