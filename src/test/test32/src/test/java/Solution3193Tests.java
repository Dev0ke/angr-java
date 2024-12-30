import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3193Tests {
    private final Solution3193 solution3193 = new Solution3193();

    @Test
    public void example1() {
        int n = 3;
        int[][] requirements = UtUtils.stringToInts2("[[2,2],[0,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3193.numberOfPermutations(n, requirements));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] requirements = UtUtils.stringToInts2("[[2,2],[1,1],[0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3193.numberOfPermutations(n, requirements));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] requirements = UtUtils.stringToInts2("[[0,0],[1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3193.numberOfPermutations(n, requirements));
    }
}