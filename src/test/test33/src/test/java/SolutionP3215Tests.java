import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3215Tests {
    private final SolutionP3215 solutionP3215 = new SolutionP3215();

    @Test
    public void example1() {
        int[] a = {1};
        int[] b = {2};
        int[] c = {3};
        long expected = 1;
        Assertions.assertEquals(expected, solutionP3215.tripletCount(a, b, c));
    }

    @Test
    public void example2() {
        int[] a = {1, 1};
        int[] b = {2, 3};
        int[] c = {1, 5};
        long expected = 4;
        Assertions.assertEquals(expected, solutionP3215.tripletCount(a, b, c));
    }
}