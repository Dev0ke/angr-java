import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2743Tests {
    private final SolutionP2743 solutionP2743 = new SolutionP2743();

    @Test
    public void example1() {
        String s = "abcd";
        int expecte = 10;
        Assertions.assertEquals(expecte, solutionP2743.numberOfSpecialSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "ooo";
        int expecte = 3;
        Assertions.assertEquals(expecte, solutionP2743.numberOfSpecialSubstrings(s));
    }

    @Test
    public void example3() {
        String s = "abab";
        int expecte = 7;
        Assertions.assertEquals(expecte, solutionP2743.numberOfSpecialSubstrings(s));
    }
}