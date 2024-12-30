import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1147Tests {
    private final Solution1147 solution1147 = new Solution1147();

    @Test
    public void example1() {
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int expected = 7;
        Assertions.assertEquals(expected, solution1147.longestDecomposition(text));
    }

    @Test
    public void example2() {
        String text = "merchant";
        int expected = 1;
        Assertions.assertEquals(expected, solution1147.longestDecomposition(text));
    }

    @Test
    public void example3() {
        String text = "antaprezatepzapreanta";
        int expected = 11;
        Assertions.assertEquals(expected, solution1147.longestDecomposition(text));
    }
}
