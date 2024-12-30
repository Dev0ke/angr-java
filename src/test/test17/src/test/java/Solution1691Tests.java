import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1691Tests {
    private final Solution1691 solution1691 = new Solution1691();

    @Test
    public void example1() {
        int[][] cuboids = UtUtils.stringToInts2("[[50,45,20],[95,37,53],[45,23,12]]");
        int expected = 190;
        Assertions.assertEquals(expected, solution1691.maxHeight(cuboids));
    }

    @Test
    public void example2() {
        int[][] cuboids = UtUtils.stringToInts2("[[38,25,45],[76,35,3]]");
        int expected = 76;
        Assertions.assertEquals(expected, solution1691.maxHeight(cuboids));
    }

    @Test
    public void example3() {
        int[][] cuboids = UtUtils.stringToInts2("[[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]");
        int expected = 102;
        Assertions.assertEquals(expected, solution1691.maxHeight(cuboids));
    }
}
