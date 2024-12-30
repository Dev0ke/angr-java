import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2533Tests {
    private final SolutionP2533 solutionP2533 = new SolutionP2533();

    @Test
    public void example1() {
        int minLength = 2;
        int maxLength = 3;
        int oneGroup = 1;
        int zeroGroup = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2533.goodBinaryStrings(minLength, maxLength, oneGroup, zeroGroup));
    }

    @Test
    public void example2() {
        int minLength = 4;
        int maxLength = 4;
        int oneGroup = 4;
        int zeroGroup = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2533.goodBinaryStrings(minLength, maxLength, oneGroup, zeroGroup));
    }
}