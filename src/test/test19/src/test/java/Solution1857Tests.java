import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1857Tests {
    private final Solution1857 solution1857 = new Solution1857();

    @Test
    public void example1() {
        String colors = "abaca";
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[3,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1857.largestPathValue(colors, edges));
    }

    @Test
    public void example2() {
        String colors = "a";
        int[][] edges = UtUtils.stringToInts2("[[0,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1857.largestPathValue(colors, edges));
    }
}
