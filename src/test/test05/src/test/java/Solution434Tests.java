import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution434Tests {
    private final Solution434 solution434 = new Solution434();

    @Test
    public void example1() {
        String s = "Hello, my name is John";
        int expected = 5;
        Assertions.assertEquals(expected, solution434.countSegments(s));
    }
}
