import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2330Tests {
    private final SolutionP2330 solutionP2330 = new SolutionP2330();

    @Test
    public void example1() {
        String s = "abcdba";
        Assertions.assertTrue(solutionP2330.makePalindrome(s));
    }

    @Test
    public void example2() {
        String s = "aa";
        Assertions.assertTrue(solutionP2330.makePalindrome(s));
    }

    @Test
    public void example3() {
        String s = "abcdef";
        Assertions.assertFalse(solutionP2330.makePalindrome(s));
    }
}