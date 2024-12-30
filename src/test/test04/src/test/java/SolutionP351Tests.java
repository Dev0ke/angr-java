import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP351Tests {
    private final SolutionP351 solutionP351 = new SolutionP351();

    @Test
    public void example1() {
        int m = 1;
        int n = 1;
        int expected = 9;
        Assertions.assertEquals(expected, solutionP351.numberOfPatterns(m, n));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 2;
        int expected = 65;
        Assertions.assertEquals(expected, solutionP351.numberOfPatterns(m, n));
    }
}