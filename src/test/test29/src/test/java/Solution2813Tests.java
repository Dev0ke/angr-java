import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2813Tests {
    private final Solution2813 solution2813 = new Solution2813();

    @Test
    public void example1() {
        int[][] items = UtUtils.stringToInts2("[[3,2],[5,1],[10,1]]");
        int k = 2;
        long expected = 17;
        Assertions.assertEquals(expected, solution2813.findMaximumElegance(items, k));
    }

    @Test
    public void example2() {
        int[][] items = UtUtils.stringToInts2("[[3,1],[3,1],[2,2],[5,3]]");
        int k = 3;
        long expected = 19;
        Assertions.assertEquals(expected, solution2813.findMaximumElegance(items, k));
    }

    @Test
    public void example3() {
        int[][] items = UtUtils.stringToInts2("[[1,1],[2,1],[3,1]]");
        int k = 3;
        long expected = 7;
        Assertions.assertEquals(expected, solution2813.findMaximumElegance(items, k));
    }
}