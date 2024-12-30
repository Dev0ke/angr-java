import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP286Tests {
    private final SolutionP286 solutionP286 = new SolutionP286();

    @Test
    public void example1() {
        int[][] rooms = UtUtils.stringToInts2("[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]");
        int[][] expected = UtUtils.stringToInts2("[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]");
        solutionP286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example2() {
        int[][] rooms = UtUtils.stringToInts2("[[-1]]");
        int[][] expected = UtUtils.stringToInts2("[[-1]]");
        solutionP286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example3() {
        int[][] rooms = UtUtils.stringToInts2("[[2147483647]]");
        int[][] expected = UtUtils.stringToInts2("[[2147483647]]");
        solutionP286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }

    @Test
    public void example4() {
        int[][] rooms = UtUtils.stringToInts2("[[0]]");
        int[][] expected = UtUtils.stringToInts2("[[0]]");
        solutionP286.wallsAndGates(rooms);
        Assertions.assertArrayEquals(expected, rooms);
    }
}
