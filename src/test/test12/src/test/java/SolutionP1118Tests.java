import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1118Tests {
    private final SolutionP1118 solutionP1118 = new SolutionP1118();

    @Test
    public void example1() {
        int year = 1992;
        int month = 7;
        int expected = 31;
        Assertions.assertEquals(expected, solutionP1118.numberOfDays(year, month));
        Assertions.assertEquals(expected, solutionP1118.numberOfDays2(year, month));
    }

    @Test
    public void example2() {
        int year = 2000;
        int month = 2;
        int expected = 29;
        Assertions.assertEquals(expected, solutionP1118.numberOfDays(year, month));
        Assertions.assertEquals(expected, solutionP1118.numberOfDays2(year, month));
    }

    @Test
    public void example3() {
        int year = 1900;
        int month = 2;
        int expected = 28;
        Assertions.assertEquals(expected, solutionP1118.numberOfDays(year, month));
        Assertions.assertEquals(expected, solutionP1118.numberOfDays2(year, month));
    }
}
