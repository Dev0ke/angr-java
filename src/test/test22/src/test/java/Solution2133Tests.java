import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2133Tests {
    private final Solution2133 solution2133 = new Solution2133();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3],[3,1,2],[2,3,1]]");
        Assertions.assertTrue(solution2133.checkValid(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,1,1],[1,2,3],[1,2,3]]");
        Assertions.assertFalse(solution2133.checkValid(matrix));
    }
}
