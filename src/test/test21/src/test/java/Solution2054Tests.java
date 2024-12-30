import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2054Tests {
    private final Solution2054 solution2054 = new Solution2054();

    @Test
    public void example1() {
        int[][] events = UtUtils.stringToInts2("[[1,3,2],[4,5,2],[2,4,3]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2054.maxTwoEvents(events));
    }

    @Test
    public void example2() {
        int[][] events = UtUtils.stringToInts2("[[1,3,2],[4,5,2],[1,5,5]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution2054.maxTwoEvents(events));
    }

    @Test
    public void example3() {
        int[][] events = UtUtils.stringToInts2("[[1,5,3],[1,5,1],[6,6,5]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution2054.maxTwoEvents(events));
    }
}
