import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1177Tests {
    private final Solution1177 solution1177 = new Solution1177();

    @Test
    public void example1() {
        String s = "abcda";
        int[][] queries = UtUtils.stringToInts2("[[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]");
        List<Boolean> expected = List.of(true, false, false, true, true);
        Assertions.assertEquals(expected, solution1177.canMakePaliQueries(s, queries));
    }
}
