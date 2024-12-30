import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP625Tests {
    private final SolutionP625 solutionP625 = new SolutionP625();

    @Test
    public void example1() {
        int num = 48;
        int expected = 68;
        Assertions.assertEquals(expected, solutionP625.smallestFactorization(num));
    }

    @Test
    public void example2() {
        int num = 15;
        int expected = 35;
        Assertions.assertEquals(expected, solutionP625.smallestFactorization(num));
    }
}
