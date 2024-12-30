import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3189Tests {
    private final SolutionP3189 solutionP3189 = new SolutionP3189();

    @Test
    public void example1() {
        int[][] rooks = UtUtils.stringToInts2("[[0,0],[1,0],[1,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3189.minMoves(rooks));
    }

    @Test
    public void example2() {
        int[][] rooks = UtUtils.stringToInts2("[[0,0],[0,1],[0,2],[0,3]]");
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3189.minMoves(rooks));
    }
}