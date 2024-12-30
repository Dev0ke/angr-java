import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2946Tests {
    private final Solution2946 solution2946 = new Solution2946();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,1,2],[5,5,5,5],[6,3,6,3]]");
        int k = 2;
        Assertions.assertTrue(solution2946.areSimilar(mat, k));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[2,2],[2,2]]");
        int k = 3;
        Assertions.assertTrue(solution2946.areSimilar(mat, k));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[1,2]]");
        int k = 1;
        Assertions.assertFalse(solution2946.areSimilar(mat, k));
    }
}