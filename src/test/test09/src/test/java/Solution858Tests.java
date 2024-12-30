import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution858Tests {
    private final Solution858 solution858 = new Solution858();

    @Test
    public void example1() {
        int p = 2;
        int q = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution858.mirrorReflection(p, q));
    }

    @Test
    public void example2() {
        int p = 3;
        int q = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution858.mirrorReflection(p, q));
    }
}