import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2345Tests {
    private final SolutionP2345 solutionP2345 = new SolutionP2345();

    @Test
    public void example1() {
        int[][] peaks = UtUtils.stringToInts2("[[2,2],[6,3],[5,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2345.visibleMountains(peaks));
    }

    @Test
    public void example2() {
        int[][] peaks = UtUtils.stringToInts2("[[1,3],[1,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2345.visibleMountains(peaks));
    }
}