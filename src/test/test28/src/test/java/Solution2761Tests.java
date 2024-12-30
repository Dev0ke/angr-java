import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2761Tests {
    private final Solution2761 solution2761 = new Solution2761();

    @Test
    public void example1() {
        int n = 10;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[3,7],[5,5]]");
        Assertions.assertEquals(expected, solution2761.findPrimePairs(n));
    }

    @Test
    public void example2() {
        int n = 2;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution2761.findPrimePairs(n));
    }
}