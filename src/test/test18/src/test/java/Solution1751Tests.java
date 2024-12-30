import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1751Tests {
    private final Solution1751 solution1751 = new Solution1751();

    @Test
    public void example1() {
        int[][] events = UtUtils.stringToInts2("[[1,2,4],[3,4,3],[2,3,1]]");
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution1751.maxValue(events, k));
    }

    @Test
    public void example2() {
        int[][] events = UtUtils.stringToInts2("[[1,2,4],[3,4,3],[2,3,10]]");
        int k = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solution1751.maxValue(events, k));
    }

    @Test
    public void example3() {
        int[][] events = UtUtils.stringToInts2("[[1,1,1],[2,2,2],[3,3,3],[4,4,4]]");
        int k = 3;
        int expected = 9;
        Assertions.assertEquals(expected, solution1751.maxValue(events, k));
    }
}
