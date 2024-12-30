import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution504Tests {
    private final Solution504 solution504 = new Solution504();

    @Test
    public void example1() {
        int num = 100;
        String expected = "202";
        Assertions.assertEquals(expected, solution504.convertToBase7(num));
    }

    @Test
    public void example2() {
        int num = -7;
        String expected = "-10";
        Assertions.assertEquals(expected, solution504.convertToBase7(num));
    }
}
