import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1933Tests {
    private final SolutionP1933 solutionP1933 = new SolutionP1933();

    @Test
    public void example1() {
        String s = "000111000";
        Assertions.assertFalse(solutionP1933.isDecomposable(s));
    }

    @Test
    public void example2() {
        String s = "00011111222";
        Assertions.assertTrue(solutionP1933.isDecomposable(s));
    }

    @Test
    public void example3() {
        String s = "01110002223300";
        Assertions.assertFalse(solutionP1933.isDecomposable(s));
    }
}