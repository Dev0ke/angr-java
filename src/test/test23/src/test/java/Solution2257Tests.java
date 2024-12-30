import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2257Tests {
    private final Solution2257 solution2257 = new Solution2257();

    @Test
    public void example1() {
        int m = 4;
        int n = 6;
        int[][] guards = UtUtils.stringToInts2("[[0,0],[1,1],[2,3]]");
        int[][] walls = UtUtils.stringToInts2("[[0,1],[2,2],[1,4]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2257.countUnguarded(m, n, guards, walls));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 3;
        int[][] guards = UtUtils.stringToInts2("[[1,1]]");
        int[][] walls = UtUtils.stringToInts2("[[0,1],[1,0],[2,1],[1,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2257.countUnguarded(m, n, guards, walls));
    }
}
