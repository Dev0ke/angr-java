import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution118Tests {
    private final Solution118 solution118 = new Solution118();

    @Test
    public void example1() {
        int numRows = 5;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]");
        Assertions.assertEquals(expected, solution118.generate(numRows));
    }

    @Test
    public void example2() {
        int numRows = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1]]");
        Assertions.assertEquals(expected, solution118.generate(numRows));
    }
}
