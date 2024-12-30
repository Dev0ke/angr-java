import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2445Tests {
    private final SolutionP2445 solutionP2445 = new SolutionP2445();

    @Test
    public void example1() {
        int n = 5;
        int[] queries = {1, 2, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2445.numberOfNodes(n, queries));
    }

    @Test
    public void example2() {
        int n = 3;
        int[] queries = {2, 3, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2445.numberOfNodes(n, queries));
    }
}