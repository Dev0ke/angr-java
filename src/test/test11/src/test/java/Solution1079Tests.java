import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1079Tests {
    private final Solution1079.V1 solution1079_v1 = new Solution1079.V1();
    private final Solution1079.V2 solution1079_v2 = new Solution1079.V2();

    @Test
    public void example1() {
        String tiles = "AAB";
        int expected = 8;
        Assertions.assertEquals(expected, solution1079_v1.numTilePossibilities(tiles));
        Assertions.assertEquals(expected, solution1079_v2.numTilePossibilities(tiles));
    }

    @Test
    public void example2() {
        String tiles = "AAABBC";
        int expected = 188;
        Assertions.assertEquals(expected, solution1079_v1.numTilePossibilities(tiles));
        Assertions.assertEquals(expected, solution1079_v2.numTilePossibilities(tiles));
    }

    @Test
    public void example3() {
        String tiles = "V";
        int expected = 1;
        Assertions.assertEquals(expected, solution1079_v1.numTilePossibilities(tiles));
        Assertions.assertEquals(expected, solution1079_v2.numTilePossibilities(tiles));
    }
}