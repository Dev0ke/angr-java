import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2218Tests {
    private final Solution2218 solution2218 = new Solution2218();

    @Test
    public void example1() {
        List<List<Integer>> piles = UtUtils.stringToIntegerList2("[[1,100,3],[7,8,9]]");
        int k = 2;
        int expected = 101;
        Assertions.assertEquals(expected, solution2218.maxValueOfCoins(piles, k));
    }

    @Test
    public void example2() {
        List<List<Integer>> piles = UtUtils.stringToIntegerList2("[[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]]");
        int k = 7;
        int expected = 706;
        Assertions.assertEquals(expected, solution2218.maxValueOfCoins(piles, k));
    }
}
