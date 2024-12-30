import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2061Tests {
    private final SolutionP2061 solutionP2061 = new SolutionP2061();

    @Test
    public void example1() {
        int[][] room = UtUtils.stringToInts2("[[0,0,0],[1,1,0],[0,0,0]]");
        int expected = 7;
        Assertions.assertEquals(expected, solutionP2061.numberOfCleanRooms(room));
    }

    @Test
    public void example2() {
        int[][] room = UtUtils.stringToInts2("[[0,1,0],[1,0,0],[0,0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2061.numberOfCleanRooms(room));
    }
}