import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP161Tests {
    private final SolutionP161 solutionP161 = new SolutionP161();

    @Test
    public void example1() {
        String s = "ab";
        String t = "acb";
        Assertions.assertTrue(solutionP161.isOneEditDistance(s, t));
    }

    @Test
    public void example2() {
        String s = "cab";
        String t = "ad";
        Assertions.assertFalse(solutionP161.isOneEditDistance(s, t));
    }

    @Test
    public void example3() {
        String s = "1203";
        String t = "1213";
        Assertions.assertTrue(solutionP161.isOneEditDistance(s, t));
    }
}
