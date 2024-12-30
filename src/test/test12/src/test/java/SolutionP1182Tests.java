import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1182Tests {
    private final SolutionP1182 solutionP1182 = new SolutionP1182();

    @Test
    public void example1() {
        int[] colors = {1, 1, 2, 1, 3, 2, 2, 3, 3};
        int[][] queries = UtUtils.stringToInts2("[[1,3],[2,2],[6,1]]");
        List<Integer> expected = List.of(3, 0, 3);
        Assertions.assertEquals(expected, solutionP1182.shortestDistanceColor(colors, queries));
    }

    @Test
    public void example2() {
        int[] colors = {1, 2};
        int[][] queries = UtUtils.stringToInts2("[[0,3]]");
        List<Integer> expected = List.of(-1);
        Assertions.assertEquals(expected, solutionP1182.shortestDistanceColor(colors, queries));
    }
}
