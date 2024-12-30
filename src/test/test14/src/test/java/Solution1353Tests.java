import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1353Tests {
    private final Solution1353 solution1353 = new Solution1353();

    @Test
    public void example1() {
        int[][] events = UtUtils.stringToInts2("[[1,2],[2,3],[3,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1353.maxEvents(events));
    }

    @Test
    public void example2() {
        int[][] events = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[1,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1353.maxEvents(events));
    }
}
