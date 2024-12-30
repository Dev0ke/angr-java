import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1589Tests {
    private final Solution1589 solution1589 = new Solution1589();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] requests = UtUtils.stringToInts2("[[1,3],[0,1]]");
        int expected = 19;
        Assertions.assertEquals(expected, solution1589.maxSumRangeQuery(nums, requests));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[][] requests = UtUtils.stringToInts2("[[0,1]]");
        int expected = 11;
        Assertions.assertEquals(expected, solution1589.maxSumRangeQuery(nums, requests));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5, 10};
        int[][] requests = UtUtils.stringToInts2("[[0,2],[1,3],[1,1]]");
        int expected = 47;
        Assertions.assertEquals(expected, solution1589.maxSumRangeQuery(nums, requests));
    }
}