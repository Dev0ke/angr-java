import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1100Tests {
    private final SolutionP1100 solutionP1100 = new SolutionP1100();

    @Test
    public void example1() {
        String s = "havefunonleetcode";
        int k = 5;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP1100.numKLenSubstrNoRepeats(s, k));
    }

    @Test
    public void example2() {
        String s = "home";
        int k = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1100.numKLenSubstrNoRepeats(s, k));
    }
}
