import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1047Tests {
    private final Solution1047 solution1047 = new Solution1047();

    @Test
    public void example1() {
        String s = "abbaca";
        String expected = "ca";
        Assertions.assertEquals(expected, solution1047.removeDuplicates(s));
    }
}
