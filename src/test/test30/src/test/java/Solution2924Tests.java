import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2924Tests {
    private final Solution2924 solution2924 = new Solution2924();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2924.findChampion(n, edges));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,2],[1,3],[1,2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution2924.findChampion(n, edges));
    }
}