import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1665Tests {
    private final Solution1665 solution1665 = new Solution1665();

    @Test
    public void example1() {
        int[][] tasks = UtUtils.stringToInts2("[[1,2],[2,4],[4,8]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution1665.minimumEffort(tasks));
    }

    @Test
    public void example2() {
        int[][] tasks = UtUtils.stringToInts2("[[1,3],[2,4],[10,11],[10,12],[8,9]]");
        int expected = 32;
        Assertions.assertEquals(expected, solution1665.minimumEffort(tasks));
    }

    @Test
    public void example3() {
        int[][] tasks = UtUtils.stringToInts2("[[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]");
        int expected = 27;
        Assertions.assertEquals(expected, solution1665.minimumEffort(tasks));
    }
}