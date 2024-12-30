import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1791Tests {
    private final Solution1791 solution1791 = new Solution1791();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,3],[4,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1791.findCenter(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[5,1],[1,3],[1,4]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1791.findCenter(edges));
    }
}
