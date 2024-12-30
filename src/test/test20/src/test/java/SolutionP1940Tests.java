import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1940Tests {
    private final SolutionP1940 solutionP1940 = new SolutionP1940();

    @Test
    public void example1() {
        int[][] arrays = UtUtils.stringToInts2("[[1,3,4],[1,4,7,9]]");
        List<Integer> expected = List.of(1, 4);
        Assertions.assertEquals(expected, solutionP1940.longestCommonSubsequence(arrays));
    }

    @Test
    public void example2() {
        int[][] arrays = UtUtils.stringToInts2("[[2,3,6,8],[1,2,3,5,6,7,10],[2,3,4,6,9]]");
        List<Integer> expected = List.of(2, 3, 6);
        Assertions.assertEquals(expected, solutionP1940.longestCommonSubsequence(arrays));
    }

    @Test
    public void example3() {
        int[][] arrays = UtUtils.stringToInts2("[[1,2,3,4,5],[6,7,8]]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solutionP1940.longestCommonSubsequence(arrays));
    }
}