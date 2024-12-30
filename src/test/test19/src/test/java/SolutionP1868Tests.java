import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1868Tests {
    private final SolutionP1868 solutionP1868 = new SolutionP1868();

    @Test
    public void example1() {
        int[][] encoded1 = UtUtils.stringToInts2("[[1,3],[2,3]]");
        int[][] encoded2 = UtUtils.stringToInts2("[[6,3],[3,3]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[6,6]]");
        Assertions.assertEquals(expected, solutionP1868.findRLEArray(encoded1, encoded2));
    }

    @Test
    public void example2() {
        int[][] encoded1 = UtUtils.stringToInts2("[[1,3],[2,1],[3,2]]");
        int[][] encoded2 = UtUtils.stringToInts2("[[2,3],[3,3]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,3],[6,1],[9,2]]");
        Assertions.assertEquals(expected, solutionP1868.findRLEArray(encoded1, encoded2));
    }
}