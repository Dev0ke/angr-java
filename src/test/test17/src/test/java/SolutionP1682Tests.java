import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1682Tests {
    private final SolutionP1682 solutionP1682 = new SolutionP1682();

    @Test
    public void example1() {
        String s = "bbabab";
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1682.longestPalindromeSubseq(s));
    }

    @Test
    public void example2() {
        String s = "dcbccacdb";
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1682.longestPalindromeSubseq(s));
    }
}