import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3199Tests {
    private final SolutionP3199 solutionP3199 = new SolutionP3199();

    @Test
    public void example1() {
        int[] a = {1};
        int[] b = {2};
        int[] c = {3};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3199.tripletCount(a, b, c));
    }

    @Test
    public void example2() {
        int[] a = {1, 1};
        int[] b = {2, 3};
        int[] c = {1, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3199.tripletCount(a, b, c));
    }
}