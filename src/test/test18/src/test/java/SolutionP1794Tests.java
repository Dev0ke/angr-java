import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1794Tests {
    private final SolutionP1794 solutionP1794 = new SolutionP1794();

    @Test
    public void example1() {
        String firstString = "abcd";
        String secondString = "bccda";
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1794.countQuadruples(firstString, secondString));
    }

    @Test
    public void example2() {
        String firstString = "ab";
        String secondString = "cd";
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1794.countQuadruples(firstString, secondString));
    }
}