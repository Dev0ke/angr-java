import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2489Tests {
    private final SolutionP2489 solutionP2489 = new SolutionP2489();

    @Test
    public void example1() {
        String s = "0110011";
        int num1 = 1;
        int num2 = 2;
        long expected = 4;
        Assertions.assertEquals(expected, solutionP2489.fixedRatio(s, num1, num2));
    }

    @Test
    public void example2() {
        String s = "10101";
        int num1 = 3;
        int num2 = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solutionP2489.fixedRatio(s, num1, num2));
    }
}