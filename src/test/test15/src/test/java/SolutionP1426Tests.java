import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1426Tests {
    private final SolutionP1426 solutionP1426 = new SolutionP1426();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1426.countElements(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 3, 3, 5, 5, 7, 7};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1426.countElements(arr));
    }
}