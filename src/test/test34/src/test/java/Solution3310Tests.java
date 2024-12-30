import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3310Tests {
    private final Solution3310 solution3310 = new Solution3310();

    @Test
    public void example1() {
        int n = 4;
        int k = 1;
        int[][] invocations = UtUtils.stringToInts2("[[1,2],[0,1],[3,2]]");
        List<Integer> expected = List.of(0, 1, 2, 3);
        Assertions.assertEquals(expected, solution3310.remainingMethods(n, k, invocations));
    }

    @Test
    public void example2() {
        int n = 5;
        int k = 0;
        int[][] invocations = UtUtils.stringToInts2("[[1,2],[0,2],[0,1],[3,4]]");
        List<Integer> expected = List.of(3, 4);
        Assertions.assertEquals(expected, solution3310.remainingMethods(n, k, invocations));
    }

    @Test
    public void example3() {
        int n = 3;
        int k = 2;
        int[][] invocations = UtUtils.stringToInts2("[[1,2],[0,1],[2,0]]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution3310.remainingMethods(n, k, invocations));
    }
}