import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2847Tests {
    private final SolutionP2847 solutionP2847 = new SolutionP2847();

    @Test
    public void example1() {
        long n = 105;
        String expected = "357";
        Assertions.assertEquals(expected, solutionP2847.smallestNumber(n));
    }

    @Test
    public void example2() {
        long n = 7;
        String expected = "7";
        Assertions.assertEquals(expected, solutionP2847.smallestNumber(n));
    }

    @Test
    public void example3() {
        long n = 44;
        String expected = "-1";
        Assertions.assertEquals(expected, solutionP2847.smallestNumber(n));
    }
}