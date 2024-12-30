import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2912Tests {
    private final SolutionP2912 solutionP2912 = new SolutionP2912();

    @Test
    public void example1() {
        int n = 3;
        int m = 2;
        int k = 2;
        int[] source = {1, 1};
        int[] dest = {2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2912.numberOfWays(n, m, k, source, dest));
    }

    @Test
    public void example2() {
        int n = 3;
        int m = 4;
        int k = 3;
        int[] source = {1, 2};
        int[] dest = {2, 3};
        int expected = 9;
        Assertions.assertEquals(expected, solutionP2912.numberOfWays(n, m, k, source, dest));
    }
}