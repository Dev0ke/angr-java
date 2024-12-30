import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution405Tests {
    private final Solution405 solution405 = new Solution405();

    @Test
    public void example1() {
        int num = 26;
        String expected = "1a";
        Assertions.assertEquals(expected, solution405.toHex(num));
    }

    @Test
    public void example2() {
        int num = -1;
        String expected = "ffffffff";
        Assertions.assertEquals(expected, solution405.toHex(num));
    }
}

