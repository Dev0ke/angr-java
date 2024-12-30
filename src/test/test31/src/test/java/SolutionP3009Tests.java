import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3009Tests {
    private final SolutionP3009 solutionP3009 = new SolutionP3009();

    @Test
    public void example1() {
        int[] y = {1, 2, 1, 2, 1, 3, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solutionP3009.maxIntersectionCount(y));
    }

    @Test
    public void example2() {
        int[] y = {2, 1, 3, 4, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3009.maxIntersectionCount(y));
    }
}