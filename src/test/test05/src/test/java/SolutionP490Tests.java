import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP490Tests {
    private final SolutionP490 solutionP490 = new SolutionP490();

    @Test
    public void example1() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]");
        int[] start = {0, 4};
        int[] destination = {4, 4};
        Assertions.assertTrue(solutionP490.hasPath(maze, start, destination));
    }

    @Test
    public void example2() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]");
        int[] start = {0, 4};
        int[] destination = {3, 2};
        Assertions.assertFalse(solutionP490.hasPath(maze, start, destination));
    }

    @Test
    public void example3() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]");
        int[] start = {4, 3};
        int[] destination = {0, 1};
        Assertions.assertFalse(solutionP490.hasPath(maze, start, destination));
    }
}
