import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1237Tests {
    private final Solution1237 solution1237 = new Solution1237();

    @Test
    public void example1() {
        Solution1237.CustomFunction customfunction = new Solution1237.CustomFunction();
        int z = 5;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,4],[2,3],[3,2],[4,1]]");
        Assertions.assertEquals(expected, solution1237.findSolution(customfunction, z));
    }
}