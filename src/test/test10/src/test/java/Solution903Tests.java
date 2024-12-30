import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution903Tests {
    private final Solution903.V1 solution903_v1 = new Solution903.V1();
    private final Solution903.V2 solution903_v2 = new Solution903.V2();

    @Test
    public void example1() {
        String s = "DID";
        int expected = 5;
        Assertions.assertEquals(expected, solution903_v1.numPermsDISequence(s));
        Assertions.assertEquals(expected, solution903_v2.numPermsDISequence(s));
    }

    @Test
    public void example2() {
        String s = "D";
        int expected = 1;
        Assertions.assertEquals(expected, solution903_v1.numPermsDISequence(s));
        Assertions.assertEquals(expected, solution903_v2.numPermsDISequence(s));
    }
}