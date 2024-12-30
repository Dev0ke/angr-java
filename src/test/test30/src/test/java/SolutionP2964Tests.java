import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2964Tests {
    private final SolutionP2964 solutionP2964 = new SolutionP2964();

    @Test
    public void example1() {
        int[] nums = {3, 3, 4, 7, 8};
        int d = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2964.divisibleTripletCount(nums, d));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 3, 3};
        int d = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2964.divisibleTripletCount(nums, d));
    }

    @Test
    public void example3() {
        int[] nums = {3, 3, 3, 3};
        int d = 6;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2964.divisibleTripletCount(nums, d));
    }
}