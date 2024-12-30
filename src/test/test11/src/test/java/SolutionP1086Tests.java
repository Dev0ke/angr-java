import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1086Tests {
    private final SolutionP1086 solutionP1086 = new SolutionP1086();

    @Test
    public void example1() {
        int[][] items = UtUtils.stringToInts2("[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]");
        int[][] expected = UtUtils.stringToInts2("[[1,87],[2,88]]");
        Assertions.assertArrayEquals(expected, solutionP1086.highFive(items));
    }

    @Test
    public void example2() {
        int[][] items = UtUtils.stringToInts2("[[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]");
        int[][] expected = UtUtils.stringToInts2("[[1,100],[7,100]]");
        Assertions.assertArrayEquals(expected, solutionP1086.highFive(items));
    }
}
