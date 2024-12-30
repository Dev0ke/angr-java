import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2363Tests {
    private final Solution2363 solution2363 = new Solution2363();

    @Test
    public void example1() {
        int[][] items1 = UtUtils.stringToInts2("[[1,1],[4,5],[3,8]]");
        int[][] items2 = UtUtils.stringToInts2("[[3,1],[1,5]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,6],[3,9],[4,5]]");
        Assertions.assertEquals(expected, solution2363.mergeSimilarItems(items1, items2));
    }

    @Test
    public void example2() {
        int[][] items1 = UtUtils.stringToInts2("[[1,1],[3,2],[2,3]]");
        int[][] items2 = UtUtils.stringToInts2("[[2,1],[3,2],[1,3]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,4],[2,4],[3,4]]");
        Assertions.assertEquals(expected, solution2363.mergeSimilarItems(items1, items2));
    }

    @Test
    public void example3() {
        int[][] items1 = UtUtils.stringToInts2("[[1,3],[2,2]]");
        int[][] items2 = UtUtils.stringToInts2("[[7,1],[2,2],[1,4]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,7],[2,4],[7,1]]");
        Assertions.assertEquals(expected, solution2363.mergeSimilarItems(items1, items2));
    }
}
