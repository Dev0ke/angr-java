import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP568Tests {
    private final SolutionP568 solutionP568 = new SolutionP568();

    @Test
    public void example1() {
        int[][] flights = UtUtils.stringToInts2("[[0,1,1],[1,0,1],[1,1,0]]");
        int[][] days = UtUtils.stringToInts2("[[1,3,1],[6,0,3],[3,3,3]]");
        int expected = 12;
        Assertions.assertEquals(expected, solutionP568.maxVacationDays(flights, days));
    }

    @Test
    public void example2() {
        int[][] flights = UtUtils.stringToInts2("[[0,0,0],[0,0,0],[0,0,0]]");
        int[][] days = UtUtils.stringToInts2("[[1,1,1],[7,7,7],[7,7,7]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP568.maxVacationDays(flights, days));
    }

    @Test
    public void example3() {
        int[][] flights = UtUtils.stringToInts2("[[0,1,1],[1,0,1],[1,1,0]]");
        int[][] days = UtUtils.stringToInts2("[[7,0,0],[0,7,0],[0,0,7]]");
        int expected = 21;
        Assertions.assertEquals(expected, solutionP568.maxVacationDays(flights, days));
    }
}
