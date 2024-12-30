import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3073Tests {
    private final SolutionP3073 solutionP3073 = new SolutionP3073();

    @Test
    public void example1() {
        int[] nums = {5, 6, 9};
        int expected = 8;
        Assertions.assertEquals(expected, solutionP3073.maximumTripletValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 3, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3073.maximumTripletValue(nums));
    }
}