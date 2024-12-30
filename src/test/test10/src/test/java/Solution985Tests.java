import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution985Tests {
    private final Solution985 solution985 = new Solution985();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int[][] queries = UtUtils.stringToInts2("[[1,0],[-3,1],[-4,0],[2,3]]");
        int[] expected = {8, 6, 2, 4};
        Assertions.assertArrayEquals(expected, solution985.sumEvenAfterQueries(nums, queries));
    }
}