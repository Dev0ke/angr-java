import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution120Tests {
    private final Solution120 solution120 = new Solution120();

    @Test
    public void example1() {
        List<List<Integer>> triangle = UtUtils.stringToIntegerList2("[[2],[3,4],[6,5,7],[4,1,8,3]]");
        int expected = 11;
        Assertions.assertEquals(expected, solution120.minimumTotal(triangle));
    }

    @Test
    public void example2() {
        List<List<Integer>> triangle = UtUtils.stringToIntegerList2("[[-10]]");
        int expected = -10;
        Assertions.assertEquals(expected, solution120.minimumTotal(triangle));
    }
}
