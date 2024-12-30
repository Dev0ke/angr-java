import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2107Tests {
    private final SolutionP2107 solutionP2107 = new SolutionP2107();

    @Test
    public void example1() {
        int[] candies = {1, 2, 2, 3, 4, 3};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2107.shareCandies(candies, k));
    }

    @Test
    public void example2() {
        int[] candies = {2, 2, 2, 2, 3, 3};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2107.shareCandies(candies, k));
    }

    @Test
    public void example3() {
        int[] candies = {2, 4, 5};
        int k = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2107.shareCandies(candies, k));
    }
}