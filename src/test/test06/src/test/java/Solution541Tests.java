import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution541Tests {
    private final Solution541 solution541 = new Solution541();

    @Test
    public void example1() {
        String s = "abcdefg";
        int k = 2;
        String expected = "bacdfeg";
        Assertions.assertEquals(expected, solution541.reverseStr(s, k));
    }

    @Test
    public void example2() {
        String s = "abcd";
        int k = 2;
        String expected = "bacd";
        Assertions.assertEquals(expected, solution541.reverseStr(s, k));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = "abcd";
        int k = 4;
        String expected = "dcba";
        Assertions.assertEquals(expected, solution541.reverseStr(s, k));
    }
}
