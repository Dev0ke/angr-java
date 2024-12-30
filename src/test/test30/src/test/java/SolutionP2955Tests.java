import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2955Tests {
    private final SolutionP2955 solutionP2955 = new SolutionP2955();

    @Test
    public void example1() {
        String s = "abcaab";
        int[][] queries = UtUtils.stringToInts2("[[0,0],[1,4],[2,5],[0,5]]");
        int[] expected = {1, 5, 5, 10};
        Assertions.assertArrayEquals(expected, solutionP2955.sameEndSubstringCount(s, queries));
    }

    @Test
    public void example2() {
        String s = "abcd";
        int[][] queries = UtUtils.stringToInts2("[[0,3]]");
        int[] expected = {4};
        Assertions.assertArrayEquals(expected, solutionP2955.sameEndSubstringCount(s, queries));
    }
}