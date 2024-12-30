import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution423Tests {
    private final Solution423 solution423 = new Solution423();

    @Test
    public void example1() {
        String s = "owoztneoer";
        String expected = "012";
        Assertions.assertEquals(expected, solution423.originalDigits(s));
    }

    @Test
    public void example2() {
        String s = "fviefuro";
        String expected = "45";
        Assertions.assertEquals(expected, solution423.originalDigits(s));
    }
}