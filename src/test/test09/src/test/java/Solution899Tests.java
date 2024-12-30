import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution899Tests {
    private final Solution899 solution899 = new Solution899();

    @Test
    public void example1() {
        String s = "cba";
        int k = 1;
        String expected = "acb";
        Assertions.assertEquals(expected, solution899.orderlyQueue(s, k));
    }

    @Test
    public void example2() {
        String s = "baaca";
        int k = 3;
        String expected = "aaabc";
        Assertions.assertEquals(expected, solution899.orderlyQueue(s, k));
    }
}
