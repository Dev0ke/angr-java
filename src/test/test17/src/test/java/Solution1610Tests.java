import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1610Tests {
    private final Solution1610 solution1610 = new Solution1610();

    @Test
    public void example1() {
        List<List<Integer>> points = UtUtils.stringToIntegerList2("[[2,1],[2,2],[3,3]]");
        int angle = 90;
        List<Integer> location = List.of(1, 1);
        int expected = 3;
        Assertions.assertEquals(expected, solution1610.visiblePoints(points, angle, location));
    }

    @Test
    public void example2() {
        List<List<Integer>> points = UtUtils.stringToIntegerList2("[[2,1],[2,2],[3,4],[1,1]]");
        int angle = 90;
        List<Integer> location = List.of(1, 1);
        int expected = 4;
        Assertions.assertEquals(expected, solution1610.visiblePoints(points, angle, location));
    }

    @Test
    public void example3() {
        List<List<Integer>> points = UtUtils.stringToIntegerList2("[[1,0],[2,1]]");
        int angle = 13;
        List<Integer> location = List.of(1, 1);
        int expected = 1;
        Assertions.assertEquals(expected, solution1610.visiblePoints(points, angle, location));
    }
}
