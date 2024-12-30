import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2638Tests {
    private final SolutionP2638 solutionP2638 = new SolutionP2638();

    @Test
    public void example1() {
        int[] nums = {5, 4, 6};
        int k = 1;
        long expected = 5;
        Assertions.assertEquals(expected, solutionP2638.countTheNumOfKFreeSubsets(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 5, 8};
        int k = 5;
        long expected = 12;
        Assertions.assertEquals(expected, solutionP2638.countTheNumOfKFreeSubsets(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {10, 5, 9, 11};
        int k = 20;
        long expected = 16;
        Assertions.assertEquals(expected, solutionP2638.countTheNumOfKFreeSubsets(nums, k));
    }
}