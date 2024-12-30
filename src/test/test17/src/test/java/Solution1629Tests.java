import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1629Tests {
    private final Solution1629 solution1629 = new Solution1629();

    @Test
    public void example1() {
        int[] releaseTimes = new int[]{9, 29, 49, 50};
        String keysPressed = "cbcd";
        char expected = 'c';
        Assertions.assertEquals(expected, solution1629.slowestKey(releaseTimes, keysPressed));
    }

    @Test
    public void example2() {
        int[] releaseTimes = new int[]{12, 23, 36, 46, 62};
        String keysPressed = "spuda";
        char expected = 'a';
        Assertions.assertEquals(expected, solution1629.slowestKey(releaseTimes, keysPressed));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] releaseTimes = UtUtils.loadingInts("solution1629-example3-input.txt", 0);
        String keysPressed = UtUtils.loadingString("solution1629-example3-input.txt", 1);
        char expected = 'n';
        Assertions.assertEquals(expected, solution1629.slowestKey(releaseTimes, keysPressed));
    }
}
