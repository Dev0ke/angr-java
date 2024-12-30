import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution886Tests {
    private final Solution886 solution886 = new Solution886();

    @Test
    public void example1() {
        int n = 4;
        int[][] dislikes = UtUtils.stringToInts2("[[1,2],[1,3],[2,4]]");
        Assertions.assertTrue(solution886.possibleBipartition(n, dislikes));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] dislikes = UtUtils.stringToInts2("[[1,2],[1,3],[2,3]]");
        Assertions.assertFalse(solution886.possibleBipartition(n, dislikes));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] dislikes = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,5],[1,5]]");
        Assertions.assertFalse(solution886.possibleBipartition(n, dislikes));
    }
}
