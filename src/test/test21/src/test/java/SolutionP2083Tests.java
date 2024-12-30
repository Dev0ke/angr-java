import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2083Tests {
    private final SolutionP2083 solutionP2083 = new SolutionP2083();

    @Test
    public void example1() {
        String s = "abcba";
        long expected = 7;
        Assertions.assertEquals(expected, solutionP2083.numberOfSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "abacad";
        long expected = 9;
        Assertions.assertEquals(expected, solutionP2083.numberOfSubstrings(s));
    }

    @Test
    public void example3() {
        String s = "a";
        long expected = 1;
        Assertions.assertEquals(expected, solutionP2083.numberOfSubstrings(s));
    }
}