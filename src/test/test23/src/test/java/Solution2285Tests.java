import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2285Tests {
    private final Solution2285 solution2285 = new Solution2285();

    @Test
    public void example1() {
        int n = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]");
        long expected = 43;
        Assertions.assertEquals(expected, solution2285.maximumImportance(n, roads));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,3],[2,4],[1,3]]");
        long expected = 20;
        Assertions.assertEquals(expected, solution2285.maximumImportance(n, roads));
    }
}
