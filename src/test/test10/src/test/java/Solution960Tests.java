import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution960Tests {
    private final Solution960 solution960 = new Solution960();

    @Test
    public void example1() {
        String[] strs = {"babca", "bbazb"};
        int expected = 3;
        Assertions.assertEquals(expected, solution960.minDeletionSize(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"edcba"};
        int expected = 4;
        Assertions.assertEquals(expected, solution960.minDeletionSize(strs));
    }

    @Test
    public void example3() {
        String[] strs = {"ghi", "def", "abc"};
        int expected = 0;
        Assertions.assertEquals(expected, solution960.minDeletionSize(strs));
    }
}