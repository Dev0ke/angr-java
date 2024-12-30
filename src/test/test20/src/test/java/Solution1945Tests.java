import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1945Tests {
    private final Solution1945 solution1945 = new Solution1945();

    @Test
    public void example1() {
        String s = "iiii";
        int k = 1;
        int expected = 36;
        Assertions.assertEquals(expected, solution1945.getLucky(s, k));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1945.getLucky(s, k));
    }
}
