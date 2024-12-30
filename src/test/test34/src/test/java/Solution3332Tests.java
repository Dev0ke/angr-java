import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3332Tests {
    private final Solution3332 solution3332 = new Solution3332();

    @Test
    public void example1() {
        int n = 2;
        int k = 1;
        int[][] stayScore = UtUtils.stringToInts2("[[2,3]]");
        int[][] travelScore = UtUtils.stringToInts2("[[0,2],[1,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3332.maxScore(n, k, stayScore, travelScore));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 2;
        int[][] stayScore = UtUtils.stringToInts2("[[3,4,2],[2,1,2]]");
        int[][] travelScore = UtUtils.stringToInts2("[[0,2,1],[2,0,4],[3,2,0]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution3332.maxScore(n, k, stayScore, travelScore));
    }
}