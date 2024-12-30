import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2983Tests {
    private final Solution2983 solution2983 = new Solution2983();

    @Test
    public void example1() {
        String s = "abcabc";
        int[][] queries = UtUtils.stringToInts2("[[1,1,3,5],[0,2,5,5]]");
        boolean[] expected = {true, true};
        Assertions.assertArrayEquals(expected, solution2983.canMakePalindromeQueries(s, queries));
    }

    @Test
    public void example2() {
        String s = "abbcdecbba";
        int[][] queries = UtUtils.stringToInts2("[[0,2,7,9]]");
        boolean[] expected = {false};
        Assertions.assertArrayEquals(expected, solution2983.canMakePalindromeQueries(s, queries));
    }

    @Test
    public void example3() {
        String s = "acbcab";
        int[][] queries = UtUtils.stringToInts2("[[1,2,4,5]]");
        boolean[] expected = {true};
        Assertions.assertArrayEquals(expected, solution2983.canMakePalindromeQueries(s, queries));
    }
}