import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1059Tests {
    private final SolutionP1059 solutionP1059 = new SolutionP1059();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int source = 0;
        int destination = 2;
        Assertions.assertFalse(solutionP1059.leadsToDestination(n, edges, source, destination));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int source = 0;
        int destination = 3;
        Assertions.assertFalse(solutionP1059.leadsToDestination(n, edges, source, destination));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[2,3]]");
        int source = 0;
        int destination = 3;
        Assertions.assertTrue(solutionP1059.leadsToDestination(n, edges, source, destination));
    }
}