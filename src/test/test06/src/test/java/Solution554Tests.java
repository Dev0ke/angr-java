import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution554Tests {
    private final Solution554 solution554 = new Solution554();

    @Test
    public void example1() {
        List<List<Integer>> wall = UtUtils.stringToIntegerList2("[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution554.leastBricks(wall));
    }

    @Test
    public void example2() {
        List<List<Integer>> wall = UtUtils.stringToIntegerList2("[[1],[1],[1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution554.leastBricks(wall));
    }
}
