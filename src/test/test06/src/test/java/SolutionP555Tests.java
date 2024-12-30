import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP555Tests {
    private final SolutionP555 solutionP555 = new SolutionP555();

    @Test
    public void example1() {
        String[] strs = {"abc", "xyz"};
        String expected = "zyxcba";
        Assertions.assertEquals(expected, solutionP555.splitLoopedString(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"abc"};
        String expected = "cba";
        Assertions.assertEquals(expected, solutionP555.splitLoopedString(strs));
    }
}