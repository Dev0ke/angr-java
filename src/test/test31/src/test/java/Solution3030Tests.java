import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3030Tests {
    private final Solution3030 solution3030 = new Solution3030();

    @Test
    public void example1() {
        int[][] image = UtUtils.stringToInts2("[[5,6,7,10],[8,9,10,10],[11,12,13,10]]");
        int threshold = 3;
        int[][] expected = UtUtils.stringToInts2("[[9,9,9,9],[9,9,9,9],[9,9,9,9]]");
        Assertions.assertArrayEquals(expected, solution3030.resultGrid(image, threshold));
    }

    @Test
    public void example2() {
        int[][] image = UtUtils.stringToInts2("[[10,20,30],[15,25,35],[20,30,40],[25,35,45]]");
        int threshold = 12;
        int[][] expected = UtUtils.stringToInts2("[[25,25,25],[27,27,27],[27,27,27],[30,30,30]]");
        Assertions.assertArrayEquals(expected, solution3030.resultGrid(image, threshold));
    }

    @Test
    public void example3() {
        int[][] image = UtUtils.stringToInts2("[[5,6,7],[8,9,10],[11,12,13]]");
        int threshold = 1;
        int[][] expected = UtUtils.stringToInts2("[[5,6,7],[8,9,10],[11,12,13]]");
        Assertions.assertArrayEquals(expected, solution3030.resultGrid(image, threshold));
    }
}