import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2380Tests {
    private final Solution2380 solution2380 = new Solution2380();

    @Test
    public void example1() {
        String s = "0110101";
        int expected = 4;
        Assertions.assertEquals(expected, solution2380.secondsToRemoveOccurrences(s));
    }

    @Test
    public void example2() {
        String s = "11100";
        int expected = 0;
        Assertions.assertEquals(expected, solution2380.secondsToRemoveOccurrences(s));
    }
}
