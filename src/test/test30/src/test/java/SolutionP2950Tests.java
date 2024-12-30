import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2950Tests {
    private final SolutionP2950 solutionP2950 = new SolutionP2950();

    @Test
    public void example1() {
        String word = "asdf";
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2950.countDivisibleSubstrings(word));
    }

    @Test
    public void example2() {
        String word = "bdh";
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2950.countDivisibleSubstrings(word));
    }

    @Test
    public void example3() {
        String word = "abcd";
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2950.countDivisibleSubstrings(word));
    }
}