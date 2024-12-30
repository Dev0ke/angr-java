import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3341Tests {
    private final Solution3341 solution3341 = new Solution3341();

    @Test
    public void example1() {
        int[][] moveTime = UtUtils.stringToInts2("[[0,4],[4,4]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution3341.minTimeToReach(moveTime));
    }

    @Test
    public void example2() {
        int[][] moveTime = UtUtils.stringToInts2("[[0,0,0],[0,0,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3341.minTimeToReach(moveTime));
    }

    @Test
    public void example3() {
        int[][] moveTime = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3341.minTimeToReach(moveTime));
    }
}