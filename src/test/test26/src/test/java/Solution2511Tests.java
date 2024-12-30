import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2511Tests {
    private final Solution2511 solution2511 = new Solution2511();

    @Test
    public void example1() {
        int[] forts = {1, 0, 0, -1, 0, 0, 0, 0, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution2511.captureForts(forts));
    }

    @Test
    public void example2() {
        int[] forts = {0, 0, 1, -1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2511.captureForts(forts));
    }
}
