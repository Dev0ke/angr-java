import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1064Tests {
    private final SolutionP1064 solutionP1064 = new SolutionP1064();

    @Test
    public void example1() {
        int[] arr = {-10, -5, 0, 3, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1064.fixedPoint(arr));
    }

    @Test
    public void example2() {
        int[] arr = {0, 2, 5, 8, 17};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1064.fixedPoint(arr));
    }

    @Test
    public void example3() {
        int[] arr = {-10, -5, 3, 4, 7, 9};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1064.fixedPoint(arr));
    }
}
