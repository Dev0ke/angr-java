import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution944Tests {
    private final Solution944 solution944 = new Solution944();

    @Test
    public void example1() {
        String[] strs = {"cba", "daf", "ghi"};
        int expected = 1;
        Assertions.assertEquals(expected, solution944.minDeletionSize(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"a", "b"};
        int expected = 0;
        Assertions.assertEquals(expected, solution944.minDeletionSize(strs));
    }

    @Test
    public void example3() {
        String[] strs = {"zyx", "wvu", "tsr"};
        int expected = 3;
        Assertions.assertEquals(expected, solution944.minDeletionSize(strs));
    }
}
