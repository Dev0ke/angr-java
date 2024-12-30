import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2662Tests {
    private final Solution2662 solution2662 = new Solution2662();

    @Test
    public void example1() {
        int[] start = {1, 1};
        int[] target = {4, 5};
        int[][] specialRoads = UtUtils.stringToInts2("[[1,2,3,3,2],[3,4,4,5,1]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution2662.minimumCost(start, target, specialRoads));
    }

    @Test
    public void example2() {
        int[] start = {3, 2};
        int[] target = {5, 7};
        int[][] specialRoads = UtUtils.stringToInts2("[[3,2,3,4,4],[3,3,5,5,5],[3,4,5,6,6]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2662.minimumCost(start, target, specialRoads));
    }
}