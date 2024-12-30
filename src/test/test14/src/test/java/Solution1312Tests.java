import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1312Tests {
    private final Solution1312 solution1312 = new Solution1312();

    @Test
    public void example1() {
        String s = "zzazz";
        int expected = 0;
        Assertions.assertEquals(expected, solution1312.minInsertions(s));
    }

    @Test
    public void example2() {
        String s = "mbadm";
        int expected = 2;
        Assertions.assertEquals(expected, solution1312.minInsertions(s));
    }

    @Test
    public void example3() {
        String s = "leetcode";
        int expected = 5;
        Assertions.assertEquals(expected, solution1312.minInsertions(s));
    }
}
