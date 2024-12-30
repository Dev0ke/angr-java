import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1259Tests {
    private final SolutionP1259 solutionP1259 = new SolutionP1259();

    @Test
    public void example1() {
        int numPeople = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1259.numberOfWays(numPeople));
    }

    @Test
    public void example2() {
        int numPeople = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1259.numberOfWays(numPeople));
    }

    @Test
    public void example3() {
        int numPeople = 6;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP1259.numberOfWays(numPeople));
    }

    @Test
    public void example4() {
        int numPeople = 8;
        int expected = 14;
        Assertions.assertEquals(expected, solutionP1259.numberOfWays(numPeople));
    }
}
