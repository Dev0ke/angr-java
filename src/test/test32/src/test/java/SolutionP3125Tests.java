import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3125Tests {
    private final SolutionP3125 solutionP3125 = new SolutionP3125();

    @Test
    public void example1() {
        long n = 7;
        long expected = 3;
        Assertions.assertEquals(expected, solutionP3125.maxNumber(n));
    }

    @Test
    public void example2() {
        long n = 9;
        long expected = 7;
        Assertions.assertEquals(expected, solutionP3125.maxNumber(n));
    }

    @Test
    public void example3() {
        long n = 17;
        long expected = 15;
        Assertions.assertEquals(expected, solutionP3125.maxNumber(n));
    }
}