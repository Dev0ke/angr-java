import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution997Tests {
    private final Solution997 solution997 = new Solution997();

    @Test
    public void example1() {
        int n = 2;
        int[][] trust = UtUtils.stringToInts2("[[1,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution997.findJudge(n, trust));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] trust = UtUtils.stringToInts2("[[1,3],[2,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution997.findJudge(n, trust));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] trust = UtUtils.stringToInts2("[[1,3],[2,3],[3,1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution997.findJudge(n, trust));
    }

    @Test
    public void example4() {
        int n = 3;
        int[][] trust = {{1, 2}, {2, 3}};
        int expected = -1;
        Assertions.assertEquals(expected, solution997.findJudge(n, trust));
    }

    @Test
    public void example5() {
        int n = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int expected = 3;
        Assertions.assertEquals(expected, solution997.findJudge(n, trust));
    }
}
