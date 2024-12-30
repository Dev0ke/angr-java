import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3342Tests {
    private final Solution3342 solution3342 = new Solution3342();

    @Test
    public void example1() {
        int[][] moveTime = UtUtils.stringToInts2("[[0,4],[4,4]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution3342.minTimeToReach(moveTime));
    }

    @Test
    public void example2() {
        int[][] moveTime = UtUtils.stringToInts2("[[0,0,0,0],[0,0,0,0]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution3342.minTimeToReach(moveTime));
    }

    @Test
    public void example3() {
        int[][] moveTime = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3342.minTimeToReach(moveTime));
    }
}