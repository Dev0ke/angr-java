import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1101Tests {
    private final SolutionP1101 solutionP1101 = new SolutionP1101();

    @Test
    public void example1() {
        int[][] logs = UtUtils.stringToInts2("[[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]]");
        int n = 6;
        int expected = 20190301;
        Assertions.assertEquals(expected, solutionP1101.earliestAcq(logs, n));
    }

    @Test
    public void example2() {
        int[][] logs = UtUtils.stringToInts2("[[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]]");
        int n = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1101.earliestAcq(logs, n));
    }
}
