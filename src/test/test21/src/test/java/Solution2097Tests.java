import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2097Tests {
    private final Solution2097 solution2097 = new Solution2097();

    @Test
    public void example1() {
        int[][] pairs = UtUtils.stringToInts2("[[5,1],[4,5],[11,9],[9,4]]");
        int[][] expected = UtUtils.stringToInts2("[[11,9],[9,4],[4,5],[5,1]]");
        Assertions.assertArrayEquals(expected, solution2097.validArrangement(pairs));
    }

    @Test
    public void example2() {
        int[][] pairs = UtUtils.stringToInts2("[[1,3],[3,2],[2,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,3],[3,2],[2,1]]");
        Assertions.assertArrayEquals(expected, solution2097.validArrangement(pairs));
    }

    @Test
    public void example3() {
        int[][] pairs = UtUtils.stringToInts2("[[1,2],[1,3],[2,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,2],[2,1],[1,3]]");
        Assertions.assertArrayEquals(expected, solution2097.validArrangement(pairs));
    }
}
