import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1730Tests {
    private final SolutionP1730 solutionP1730 = new SolutionP1730();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1730.getFood(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
                """);
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1730.getFood(grid));
    }

    @Test
    public void example3() {
        char[][] grid = UtUtils.stringToChars2("""
                [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
                """);
        int expected = 6;
        Assertions.assertEquals(expected, solutionP1730.getFood(grid));
    }
}