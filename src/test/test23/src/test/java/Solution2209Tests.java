import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2209Tests {
    private final Solution2209 solution2209 = new Solution2209();

    @Test
    public void example1() {
        String floor = "10110101";
        int numCarpets = 2;
        int carpetLen = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles(floor, numCarpets, carpetLen));
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles2(floor, numCarpets, carpetLen));
    }

    @Test
    public void example2() {
        String floor = "11111";
        int numCarpets = 2;
        int carpetLen = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles(floor, numCarpets, carpetLen));
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles2(floor, numCarpets, carpetLen));
    }

    // 补充用例
    @Test
    public void example3() {
        // 2696 / 2698 个通过测试用例
        String floor = "111111111101001101111110001011111111111111111111011111111111111111111101101011111111111111101100010010111111100111110010110111110111111111100011111011111011111111111110100110101011111111110101001111101111110111111111111101";
        int numCarpets = 43;
        int carpetLen = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles(floor, numCarpets, carpetLen));
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles2(floor, numCarpets, carpetLen));
    }

    @Test
    public void example4() {
        // 2697 / 2698 个通过测试用例
        String floor = "101111";
        int numCarpets = 2;
        int carpetLen = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles(floor, numCarpets, carpetLen));
        Assertions.assertEquals(expected, solution2209.minimumWhiteTiles2(floor, numCarpets, carpetLen));
    }
}