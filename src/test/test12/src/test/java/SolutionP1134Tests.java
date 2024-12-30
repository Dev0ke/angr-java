import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1134Tests {
    private final SolutionP1134 solutionP1134 = new SolutionP1134();

    @Test
    public void example1() {
        int n = 153;
        Assertions.assertTrue(solutionP1134.isArmstrong(n));
    }

    @Test
    public void example2() {
        int n = 123;
        Assertions.assertFalse(solutionP1134.isArmstrong(n));
    }
}
