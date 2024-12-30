import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2647Tests {
    private final SolutionP2647 solutionP2647 = new SolutionP2647();

    @Test
    public void example1() {
        int size = 3;
        int[][] expected = UtUtils.stringToInts2("[[1,1],[2,1],[2,3],[3,1],[3,5]]");
        // 如果有多个有效的解决方案，请返回其中任意一个。
//        Assertions.assertArrayEquals(expected, solutionP2647.colorRed(size));
        Assertions.assertEquals(expected.length, solutionP2647.colorRed(size).length);
    }

    @Test
    public void example2() {
        int size = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,1],[2,1],[2,3]]");
//        Assertions.assertArrayEquals(expected, solutionP2647.colorRed(size));
        Assertions.assertEquals(expected.length, solutionP2647.colorRed(size).length);
    }
}