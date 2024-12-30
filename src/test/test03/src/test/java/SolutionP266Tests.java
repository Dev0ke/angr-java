import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP266Tests {
    private final SolutionP266 solutionP266 = new SolutionP266();

    @Test
    public void example1() {
        String s = "code";
        Assertions.assertFalse(solutionP266.canPermutePalindrome(s));
    }

    @Test
    public void example2() {
        String s = "aab";
        Assertions.assertTrue(solutionP266.canPermutePalindrome(s));
    }

    @Test
    public void example3() {
        String s = "carerac";
        Assertions.assertTrue(solutionP266.canPermutePalindrome(s));
    }
}
