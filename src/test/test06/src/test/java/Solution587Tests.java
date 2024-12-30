import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution587Tests {
    private final Solution587 solution587 = new Solution587();

    @Test
    public void example1() {
        int[][] trees = UtUtils.stringToInts2("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1],[2,0],[3,3],[2,4],[4,2]]");
        int[][] actual = solution587.outerTrees(trees);
        Arrays.sort(expected, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(actual, Comparator.comparingInt(o -> o[0]));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[][] trees = UtUtils.stringToInts2("[[1,2],[2,2],[4,2]]");
        int[][] expected = UtUtils.stringToInts2("[[4,2],[2,2],[1,2]]");
        int[][] actual = solution587.outerTrees(trees);
        Arrays.sort(expected, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(actual, Comparator.comparingInt(o -> o[0]));
        Assertions.assertArrayEquals(expected, actual);
    }
}