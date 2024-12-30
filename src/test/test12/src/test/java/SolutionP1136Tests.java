import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1136Tests {
    private final SolutionP1136 solutionP1136 = new SolutionP1136();

    @Test
    public void example1() {
        int n = 3;
        int[][] relations = UtUtils.stringToInts2("[[1,3],[2,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1136.minimumSemesters(n, relations));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] relations = UtUtils.stringToInts2("[[1,2],[2,3],[3,1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1136.minimumSemesters(n, relations));
    }
}
