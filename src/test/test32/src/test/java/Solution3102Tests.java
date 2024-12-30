import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3102Tests {
    private final Solution3102 solution3102 = new Solution3102();

    @Test
    public void example1() {
        int[][] point = UtUtils.stringToInts2("[[3,10],[5,15],[10,2],[4,4]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution3102.minimumDistance(point));
    }

    @Test
    public void example2() {
        int[][] point = UtUtils.stringToInts2("[[1,1],[1,1],[1,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3102.minimumDistance(point));
    }
}