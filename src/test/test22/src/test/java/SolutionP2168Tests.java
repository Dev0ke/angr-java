import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2168Tests {
    private final SolutionP2168 solutionP2168 = new SolutionP2168();

    @Test
    public void example1() {
        String s = "1212";
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2168.equalDigitFrequency(s));
    }

    @Test
    public void example2() {
        String s = "12321";
        int expected = 9;
        Assertions.assertEquals(expected, solutionP2168.equalDigitFrequency(s));
    }
}