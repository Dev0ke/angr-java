import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1057Tests {
    private final SolutionP1057 solutionP1057 = new SolutionP1057();

    @Test
    public void example1() {
        int[][] workers = UtUtils.stringToInts2("[[0,0],[2,1]]");
        int[][] bikes = UtUtils.stringToInts2("[[1,2],[3,3]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solutionP1057.assignBikes(workers, bikes));
    }

    @Test
    public void example2() {
        int[][] workers = UtUtils.stringToInts2("[[0,0],[1,1],[2,0]]");
        int[][] bikes = UtUtils.stringToInts2("[[1,0],[2,2],[2,1]]");
        int[] expected = {0, 2, 1};
        Assertions.assertArrayEquals(expected, solutionP1057.assignBikes(workers, bikes));
    }
}
