import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1989Tests {
    private final SolutionP1989 solutionP1989 = new SolutionP1989();

    @Test
    public void example1() {
        int[] team = {0, 1, 0, 1, 0};
        int dist = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1989.catchMaximumAmountofPeople(team, dist));
    }

    @Test
    public void example2() {
        int[] team = {1};
        int dist = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1989.catchMaximumAmountofPeople(team, dist));
    }

    @Test
    public void example3() {
        int[] team = {0};
        int dist = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1989.catchMaximumAmountofPeople(team, dist));
    }
}
