import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3261Tests {
    private final Solution3261 solution3261 = new Solution3261();

    @Test
    public void example1() {
        String s = "0001111";
        int k = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,6]]");
        long[] expected = {26};
        Assertions.assertArrayEquals(expected, solution3261.countKConstraintSubstrings(s, k, queries));
    }

    @Test
    public void example2() {
        String s = "010101";
        int k = 1;
        int[][] queries = UtUtils.stringToInts2("[[0,5],[1,4],[2,3]]");
        long[] expected = {15, 9, 3};
        Assertions.assertArrayEquals(expected, solution3261.countKConstraintSubstrings(s, k, queries));
    }
}