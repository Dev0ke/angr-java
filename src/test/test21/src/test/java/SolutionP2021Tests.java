import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2021Tests {
    private final SolutionP2021 solutionP2021 = new SolutionP2021();

    @Test
    public void example1() {
        int[][] lights = UtUtils.stringToInts2("[[-3,2],[1,2],[3,3]]");
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2021.brightestPosition(lights));
        Assertions.assertEquals(expected, solutionP2021.brightestPosition2(lights));
    }

    @Test
    public void example2() {
        int[][] lights = UtUtils.stringToInts2("[[1,0],[0,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2021.brightestPosition(lights));
        Assertions.assertEquals(expected, solutionP2021.brightestPosition2(lights));
    }

    @Test
    public void example3() {
        int[][] lights = UtUtils.stringToInts2("[[1,2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2021.brightestPosition(lights));
        Assertions.assertEquals(expected, solutionP2021.brightestPosition2(lights));
    }
}