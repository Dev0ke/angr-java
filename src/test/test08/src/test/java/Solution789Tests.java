import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution789Tests {
    private final Solution789 solution789 = new Solution789();

    @Test
    public void example1() {
        int[][] ghosts = UtUtils.stringToInts2("[[1,0],[0,3]]");
        int[] target = {0, 1};
        Assertions.assertTrue(solution789.escapeGhosts(ghosts, target));
    }

    @Test
    public void example2() {
        int[][] ghosts = UtUtils.stringToInts2("[[1,0]]");
        int[] target = {2, 0};
        Assertions.assertFalse(solution789.escapeGhosts(ghosts, target));
    }

    @Test
    public void example3() {
        int[][] ghosts = UtUtils.stringToInts2("[[2,0]]");
        int[] target = {1, 0};
        Assertions.assertFalse(solution789.escapeGhosts(ghosts, target));
    }
}