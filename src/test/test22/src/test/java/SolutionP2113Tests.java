import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2113Tests {
    private final SolutionP2113 solutionP2113 = new SolutionP2113();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[2,0],[3,2],[5,0]]");
        int[] expected = {2, 2, -1, 0};
        Assertions.assertArrayEquals(expected, solutionP2113.elementInNums(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2};
        int[][] queries = UtUtils.stringToInts2("[[0,0],[1,0],[2,0],[3,0]]");
        int[] expected = {2, -1, 2, -1};
        Assertions.assertArrayEquals(expected, solutionP2113.elementInNums(nums, queries));
    }
}