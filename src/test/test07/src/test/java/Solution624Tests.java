import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution624Tests {
    private final Solution624 solution624 = new Solution624();

    @Test
    public void example1() {
        List<List<Integer>> arrays = UtUtils.stringToIntegerList2("[[1,2,3], [4,5], [1,2,3]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution624.maxDistance(arrays));
    }
}