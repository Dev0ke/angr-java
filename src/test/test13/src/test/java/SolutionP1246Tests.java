import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1246Tests {
    private final SolutionP1246 solutionP1246 = new SolutionP1246();

    @Test
    public void example1() {
        int[] arr = {1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1246.minimumMoves(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 3, 4, 1, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1246.minimumMoves(arr));
    }
}
