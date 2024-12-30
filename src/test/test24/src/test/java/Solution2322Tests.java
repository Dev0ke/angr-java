import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2322Tests {
    private final Solution2322 solution2322 = new Solution2322();

    @Test
    public void example1() {
        int[] nums = {1, 5, 5, 4, 11};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[3,4]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution2322.minimumScore(nums, edges));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 2, 4, 4, 2};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[5,2],[4,3],[1,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2322.minimumScore(nums, edges));
    }
}
