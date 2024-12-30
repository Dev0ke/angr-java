import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP651Tests {
    private final SolutionP651 solutionP651 = new SolutionP651();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP651.maxA(n));
    }

    @Test
    public void example2() {
        int n = 7;
        int expected = 9;
        Assertions.assertEquals(expected, solutionP651.maxA(n));
    }
}
