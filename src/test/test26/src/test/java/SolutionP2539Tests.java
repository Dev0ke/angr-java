import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2539Tests {
    private final SolutionP2539 solutionP2539 = new SolutionP2539();

    @Test
    public void example1() {
        String s = "aabb";
        int expected = 11;
        Assertions.assertEquals(expected, solutionP2539.countGoodSubsequences(s));
    }

    @Test
    public void example2() {
        String s = "leet";
        int expected = 12;
        Assertions.assertEquals(expected, solutionP2539.countGoodSubsequences(s));
    }

    @Test
    public void example3() {
        String s = "abcd";
        int expected = 15;
        Assertions.assertEquals(expected, solutionP2539.countGoodSubsequences(s));
    }
}