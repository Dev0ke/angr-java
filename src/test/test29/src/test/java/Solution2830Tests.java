import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2830Tests {
    private final Solution2830 solution2830 = new Solution2830();

    @Test
    public void example1() {
        int n = 5;
        List<List<Integer>> offers = UtUtils.stringToIntegerList2("[[0,0,1],[0,2,2],[1,3,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2830.maximizeTheProfit(n, offers));
        Assertions.assertEquals(expected, solution2830.maximizeTheProfit2(n, offers));
    }

    @Test
    public void example2() {
        int n = 5;
        List<List<Integer>> offers = UtUtils.stringToIntegerList2("[[0,0,1],[0,2,10],[1,3,2]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution2830.maximizeTheProfit(n, offers));
        Assertions.assertEquals(expected, solution2830.maximizeTheProfit2(n, offers));
    }
}