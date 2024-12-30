import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution752Tests {
    private final Solution752 solution752 = new Solution752();

    @Test
    public void example1() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int expected = 6;
        Assertions.assertEquals(expected, solution752.openLock(deadends, target));
    }

    @Test
    public void example2() {
        String[] deadends = {"8888"};
        String target = "0009";
        int expected = 1;
        Assertions.assertEquals(expected, solution752.openLock(deadends, target));
    }

    @Test
    public void example3() {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";
        int expected = -1;
        Assertions.assertEquals(expected, solution752.openLock(deadends, target));
    }

    @Test
    public void example4() {
        String[] deadends = {"0000"};
        String target = "8888";
        int expected = -1;
        Assertions.assertEquals(expected, solution752.openLock(deadends, target));
    }
}
