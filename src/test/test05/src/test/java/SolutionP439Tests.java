import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP439Tests {
    private final SolutionP439 solutionP439 = new SolutionP439();

    @Test
    public void example1() {
        String expression = "T?2:3";
        String expected = "2";
        Assertions.assertEquals(expected, solutionP439.parseTernary(expression));
    }

    @Test
    public void example2() {
        String expression = "F?1:T?4:5";
        String expected = "4";
        Assertions.assertEquals(expected, solutionP439.parseTernary(expression));
    }

    @Test
    public void example3() {
        String expression = "T?T?F:5:3";
        String expected = "F";
        Assertions.assertEquals(expected, solutionP439.parseTernary(expression));
    }
}
