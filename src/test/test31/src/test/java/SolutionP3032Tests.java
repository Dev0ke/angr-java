import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3032Tests {
    private final SolutionP3032 solutionP3032 = new SolutionP3032();

    @Test
    public void example1() {
        int a = 1;
        int b = 20;
        int expected = 19;
        Assertions.assertEquals(expected, solutionP3032.numberCount(a, b));
    }

    @Test
    public void example2() {
        int a = 9;
        int b = 19;
        int expected = 10;
        Assertions.assertEquals(expected, solutionP3032.numberCount(a, b));
    }

    @Test
    public void example3() {
        int a = 80;
        int b = 120;
        int expected = 27;
        Assertions.assertEquals(expected, solutionP3032.numberCount(a, b));
    }
}