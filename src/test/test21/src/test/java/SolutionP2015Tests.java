import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2015Tests {
    private final SolutionP2015 solutionP2015 = new SolutionP2015();

    @Test
    public void example1() {
        int[][] buildings = UtUtils.stringToInts2("[[1,4,2],[3,9,4]]");
        int[][] expected = UtUtils.stringToInts2("[[1,3,2],[3,4,3],[4,9,4]]");
        Assertions.assertArrayEquals(expected, solutionP2015.averageHeightOfBuildings(buildings));
    }

    @Test
    public void example2() {
        int[][] buildings = UtUtils.stringToInts2("[[1,3,2],[2,5,3],[2,8,3]]");
        int[][] expected = UtUtils.stringToInts2("[[1,3,2],[3,8,3]]");
        Assertions.assertArrayEquals(expected, solutionP2015.averageHeightOfBuildings(buildings));
    }

    @Test
    public void example3() {
        int[][] buildings = UtUtils.stringToInts2("[[1,2,1],[5,6,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,2,1],[5,6,1]]");
        Assertions.assertArrayEquals(expected, solutionP2015.averageHeightOfBuildings(buildings));
    }
}