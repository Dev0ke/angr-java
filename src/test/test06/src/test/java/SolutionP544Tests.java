import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP544Tests {
    private final SolutionP544 solutionP544 = new SolutionP544();

    @Test
    public void example1() {
        int n = 4;
        String expected = "((1,4),(2,3))";
        Assertions.assertEquals(expected, solutionP544.findContestMatch(n));
    }

    @Test
    public void example2() {
        int n = 8;
        String expected = "(((1,8),(4,5)),((2,7),(3,6)))";
        Assertions.assertEquals(expected, solutionP544.findContestMatch(n));
    }
}