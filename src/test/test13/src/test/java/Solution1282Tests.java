import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1282Tests {
    private final Solution1282 solution1282 = new Solution1282();

    @Test
    public void example1() {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        // 答案不唯一
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[5],[0,1,2],[3,4,6]]");
        Assertions.assertEquals(expected, solution1282.groupThePeople(groupSizes));
    }

    @Test
    public void example2() {
        int[] groupSizes = {2, 1, 3, 3, 3, 2};
        // 答案不唯一
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1],[0,5],[2,3,4]]");
        Assertions.assertEquals(expected, solution1282.groupThePeople(groupSizes));
    }
}
