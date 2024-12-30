import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2271Tests {
    private final Solution2271 solution2271 = new Solution2271();

    @Test
    public void example1() {
        int[][] tiles = UtUtils.stringToInts2("[[1,5],[10,11],[12,18],[20,25],[30,32]]");
        int carpetLen = 10;
        int expected = 9;
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles(tiles, carpetLen));
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles2(tiles, carpetLen));
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles3(tiles, carpetLen));
    }

    @Test
    public void example2() {
        int[][] tiles = UtUtils.stringToInts2("[[10,11],[1,1]]");
        int carpetLen = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles(tiles, carpetLen));
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles2(tiles, carpetLen));
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles3(tiles, carpetLen));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/313535352/
        // 28 / 40 个通过测试用例
        int[][] tiles = UtUtils.loadingInts2("solution2271-example3-input.txt", 0);
        int carpetLen = UtUtils.loadingInt("solution2271-example3-input.txt", 1);
        int expected = 1625375;
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles(tiles, carpetLen));
//        Assertions.assertEquals(expected, solution6068.maximumWhiteTiles2(tiles, carpetLen));
        Assertions.assertEquals(expected, solution2271.maximumWhiteTiles3(tiles, carpetLen));
    }
}
