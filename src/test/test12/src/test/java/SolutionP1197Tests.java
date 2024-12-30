import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1197Tests {
    private final SolutionP1197 solutionP1197 = new SolutionP1197();

    @Test
    public void example1() {
        int x = 2;
        int y = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1197.minKnightMoves(x, y));
    }

    @Test
    public void example2() {
        int x = 5;
        int y = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1197.minKnightMoves(x, y));
    }
}