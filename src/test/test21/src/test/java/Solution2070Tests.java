import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2070Tests {
    private final Solution2070 solution2070 = new Solution2070();

    @Test
    public void example1() {
        int[][] items = UtUtils.stringToInts2("[[1,2],[3,2],[2,4],[5,6],[3,5]]");
        int[] queries = {1, 2, 3, 4, 5, 6};
        int[] expected = {2, 4, 5, 5, 6, 6};
        Assertions.assertArrayEquals(expected, solution2070.maximumBeauty(items, queries));
    }

    @Test
    public void example2() {
        int[][] items = UtUtils.stringToInts2("[[1,2],[1,2],[1,3],[1,4]]");
        int[] queries = {1};
        int[] expected = {4};
        Assertions.assertArrayEquals(expected, solution2070.maximumBeauty(items, queries));
    }

    @Test
    public void example3() {
        int[][] items = UtUtils.stringToInts2("[[10,1000]]");
        int[] queries = {5};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution2070.maximumBeauty(items, queries));
    }
}
