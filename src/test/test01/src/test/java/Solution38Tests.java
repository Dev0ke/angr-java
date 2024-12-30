import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution38Tests {
    private final Solution38 solution38 = new Solution38();

    @Test
    public void example1() {
        int n = 1;
        String expected = "1";
        Assertions.assertEquals(expected, solution38.countAndSay(n));
    }

    @Test
    public void example2() {
        int n = 4;
        String expected = "1211";
        Assertions.assertEquals(expected, solution38.countAndSay(n));
    }
}
