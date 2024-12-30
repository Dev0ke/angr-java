import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1999Tests {
    private final SolutionP1999 solutionP1999 = new SolutionP1999();

    @Test
    public void example1() {
        int k = 2;
        int digit1 = 0;
        int digit2 = 2;
        int expected = 20;
        Assertions.assertEquals(expected, solutionP1999.findInteger(k, digit1, digit2));
    }

    @Test
    public void example2() {
        int k = 3;
        int digit1 = 4;
        int digit2 = 2;
        int expected = 24;
        Assertions.assertEquals(expected, solutionP1999.findInteger(k, digit1, digit2));
    }

    @Test
    public void example3() {
        int k = 2;
        int digit1 = 0;
        int digit2 = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1999.findInteger(k, digit1, digit2));
    }
}