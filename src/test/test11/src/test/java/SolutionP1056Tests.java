import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1056Tests {
    private final SolutionP1056 solutionP1056 = new SolutionP1056();

    @Test
    public void example1() {
        int n = 6;
        Assertions.assertTrue(solutionP1056.confusingNumber(n));
    }

    @Test
    public void example2() {
        int n = 89;
        Assertions.assertTrue(solutionP1056.confusingNumber(n));
    }

    @Test
    public void example3() {
        int n = 11;
        Assertions.assertFalse(solutionP1056.confusingNumber(n));
    }

    @Test
    public void example4() {
        int n = 25;
        Assertions.assertFalse(solutionP1056.confusingNumber(n));
    }
}
