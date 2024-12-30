import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution675Tests {
    private final Solution675 solution675 = new Solution675();

    @Test
    public void example1() {
        List<List<Integer>> forest = UtUtils.stringToIntegerList2("[[1,2,3],[0,0,4],[7,6,5]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution675.cutOffTree(forest));
    }

    @Test
    public void example2() {
        List<List<Integer>> forest = UtUtils.stringToIntegerList2("[[1,2,3],[0,0,0],[7,6,5]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution675.cutOffTree(forest));
    }

    @Test
    public void example3() {
        List<List<Integer>> forest = UtUtils.stringToIntegerList2("[[2,3,4],[0,0,5],[8,7,6]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution675.cutOffTree(forest));
    }
}
