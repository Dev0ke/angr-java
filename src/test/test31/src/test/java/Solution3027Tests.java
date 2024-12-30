import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3027Tests {
    private final Solution3027 solution3027 = new Solution3027();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3027.numberOfPairs(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[6,2],[4,4],[2,6]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3027.numberOfPairs(points));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[3,1],[1,3],[1,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3027.numberOfPairs(points));
    }
}