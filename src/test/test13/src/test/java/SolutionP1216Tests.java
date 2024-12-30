import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1216Tests {
    private final SolutionP1216 solutionP1216 = new SolutionP1216();

    @Test
    public void example1() {
        String s = "abcdeca";
        int k = 2;
        Assertions.assertTrue(solutionP1216.isValidPalindrome(s, k));
    }

    @Test
    public void example2() {
        String s = "abbababa";
        int k = 1;
        Assertions.assertTrue(solutionP1216.isValidPalindrome(s, k));
    }
}