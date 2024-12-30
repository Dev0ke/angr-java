import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP294Tests {
    private final SolutionP294 solutionP294 = new SolutionP294();

    @Test
    public void example1() {
        String currentState = "++++";
        Assertions.assertTrue(solutionP294.canWin(currentState));
    }

    @Test
    public void example2() {
        String currentState = "+";
        Assertions.assertFalse(solutionP294.canWin(currentState));
    }
}
