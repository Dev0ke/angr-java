import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1714Tests {
    private final SolutionP1714 solutionP1714 = new SolutionP1714();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        int[][] queries = UtUtils.stringToInts2("[[0,3],[5,1],[4,2]]");
        int[] expected = {9, 18, 10};
        Assertions.assertArrayEquals(expected, solutionP1714.solve(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {100, 200, 101, 201, 102, 202, 103, 203};
        int[][] queries = UtUtils.stringToInts2("[[0,7]]");
        int[] expected = {303};
        Assertions.assertArrayEquals(expected, solutionP1714.solve(nums, queries));
    }
}