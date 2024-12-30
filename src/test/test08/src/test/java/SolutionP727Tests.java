import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP727Tests {
    private final SolutionP727 solutionP727 = new SolutionP727();

    @Test
    public void example1() {
        String s1 = "abcdebdde";
        String s2 = "bde";
        String expected = "bcde";
        Assertions.assertEquals(expected, solutionP727.minWindow(s1, s2));
    }
}
