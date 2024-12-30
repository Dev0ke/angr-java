import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2237Tests {
    private final SolutionP2237 solutionP2237 = new SolutionP2237();

    @Test
    public void example1() {
        int n = 5;
        int[][] lights = UtUtils.stringToInts2("[[0,1],[2,1],[3,2]]");
        int[] requirement = {0, 2, 1, 4, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2237.meetRequirement(n, lights, requirement));
    }

    @Test
    public void example2() {
        int n = 1;
        int[][] lights = UtUtils.stringToInts2("[[0,1]]");
        int[] requirement = {2};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2237.meetRequirement(n, lights, requirement));
    }
}