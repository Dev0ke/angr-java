import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2138Tests {
    private final Solution2138 solution2138 = new Solution2138();

    @Test
    public void example1() {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        String[] expected = {"abc", "def", "ghi"};
        Assertions.assertArrayEquals(expected, solution2138.divideString(s, k, fill));
    }

    @Test
    public void example2() {
        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';
        String[] expected = {"abc", "def", "ghi", "jxx"};
        Assertions.assertArrayEquals(expected, solution2138.divideString(s, k, fill));
    }
}
