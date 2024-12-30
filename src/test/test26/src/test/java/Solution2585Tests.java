import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2585Tests {
    private final Solution2585 solution2585 = new Solution2585();

    @Test
    public void example1() {
        int target = 6;
        int[][] types = UtUtils.stringToInts2("[[6,1],[3,2],[2,3]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2585.waysToReachTarget(target, types));
    }

    @Test
    public void example2() {
        int target = 5;
        int[][] types = UtUtils.stringToInts2("[[50,1],[50,2],[50,5]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2585.waysToReachTarget(target, types));
    }

    @Test
    public void example3() {
        int target = 18;
        int[][] types = UtUtils.stringToInts2("[[6,1],[3,2],[2,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2585.waysToReachTarget(target, types));
    }
}