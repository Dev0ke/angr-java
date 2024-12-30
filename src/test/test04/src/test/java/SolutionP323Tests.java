import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP323Tests {
    private final SolutionP323 solutionP323 = new SolutionP323();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0, 1], [1, 2], [3, 4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP323.countComponents(n, edges));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1], [1,2], [2,3], [3,4]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP323.countComponents(n, edges));
    }
}
