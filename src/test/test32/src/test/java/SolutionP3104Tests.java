import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3104Tests {
    private final SolutionP3104 solutionP3104 = new SolutionP3104();

    @Test
    public void example1() {
        String s = "abba";
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3104.maxSubstringLength(s));
    }

    @Test
    public void example2() {
        String s = "abab";
        int expected = -1;
        Assertions.assertEquals(expected, solutionP3104.maxSubstringLength(s));
    }

    @Test
    public void example3() {
        String s = "abacd";
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3104.maxSubstringLength(s));
    }
}