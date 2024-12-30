import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1654Tests {
    private final Solution1654 solution1654 = new Solution1654();

    @Test
    public void example1() {
        int[] forbidden = {14, 4, 18, 1, 15};
        int a = 3;
        int b = 15;
        int x = 9;
        int expected = 3;
        Assertions.assertEquals(expected, solution1654.minimumJumps(forbidden, a, b, x));
    }

    @Test
    public void example2() {
        int[] forbidden = {8, 3, 16, 6, 12, 20};
        int a = 15;
        int b = 13;
        int x = 11;
        int expected = -1;
        Assertions.assertEquals(expected, solution1654.minimumJumps(forbidden, a, b, x));
    }

    @Test
    public void example3() {
        int[] forbidden = {1, 6, 2, 14, 5, 17, 4};
        int a = 16;
        int b = 9;
        int x = 7;
        int expected = 2;
        Assertions.assertEquals(expected, solution1654.minimumJumps(forbidden, a, b, x));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] forbidden = {18, 13, 3, 9, 8, 14};
        int a = 3;
        int b = 8;
        int x = 6;
        int expected = -1;
        Assertions.assertEquals(expected, solution1654.minimumJumps(forbidden, a, b, x));
    }

    @Test
    public void example5() {
        int[] forbidden = {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98};
        int a = 29;
        int b = 98;
        int x = 80;
        int expected = 121;
        Assertions.assertEquals(expected, solution1654.minimumJumps(forbidden, a, b, x));
    }
}