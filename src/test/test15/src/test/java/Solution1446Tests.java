import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1446Tests {
    private final Solution1446 solution1446 = new Solution1446();

    @Test
    public void example1() {
        String s = "leetcode";
        int expected = 2;
        Assertions.assertEquals(expected, solution1446.maxPower(s));
    }

    @Test
    public void example2() {
        String s = "abbcccddddeeeeedcba";
        int expected = 5;
        Assertions.assertEquals(expected, solution1446.maxPower(s));
    }

    @Test
    public void example3() {
        String s = "triplepillooooow";
        int expected = 5;
        Assertions.assertEquals(expected, solution1446.maxPower(s));
    }

    @Test
    public void example4() {
        String s = "hooraaaaaaaaaaay";
        int expected = 11;
        Assertions.assertEquals(expected, solution1446.maxPower(s));
    }

    @Test
    public void example5() {
        String s = "tourist";
        int expected = 1;
        Assertions.assertEquals(expected, solution1446.maxPower(s));
    }

    // 补充用例
    @Test
    public void example6() {
        String s = "j";
        int expected = 1;
        Assertions.assertEquals(expected, solution1446.maxPower(s));
    }

    @Test
    public void example7() {
        String s = "cc";
        int expected = 2;
        Assertions.assertEquals(expected, solution1446.maxPower(s));
    }
}
