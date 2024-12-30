import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2417Tests {
    private final SolutionP2417 solutionP2417 = new SolutionP2417();

    @Test
    public void example1() {
        int n = 2;
        int expected = 10;
        Assertions.assertEquals(expected, solutionP2417.closestFair(n));
    }

    @Test
    public void example2() {
        int n = 403;
        int expected = 1001;
        Assertions.assertEquals(expected, solutionP2417.closestFair(n));
    }
}