import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution841Tests {
    private final Solution841 solution841 = new Solution841();

    @Test
    public void example1() {
        List<List<Integer>> rooms = UtUtils.stringToIntegerList2("[[1],[2],[3],[]]");
        Assertions.assertTrue(solution841.canVisitAllRooms(rooms));
    }

    @Test
    public void example2() {
        List<List<Integer>> rooms = UtUtils.stringToIntegerList2("[[1,3],[3,0,1],[2],[0]]");
        Assertions.assertFalse(solution841.canVisitAllRooms(rooms));
    }
}
