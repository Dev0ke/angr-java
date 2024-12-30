import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP246Tests {
    private final SolutionP246 solutionP246 = new SolutionP246();

    @Test
    public void example1() {
        String num = "69";
        Assertions.assertTrue(solutionP246.isStrobogrammatic(num));
    }

    @Test
    public void example2() {
        String num = "88";
        Assertions.assertTrue(solutionP246.isStrobogrammatic(num));
    }

    @Test
    public void example3() {
        String num = "962";
        Assertions.assertFalse(solutionP246.isStrobogrammatic(num));
    }

    @Test
    public void example4() {
        String num = "1";
        Assertions.assertTrue(solutionP246.isStrobogrammatic(num));
    }
}
