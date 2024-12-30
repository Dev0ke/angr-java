import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution514Tests {
    private final Solution514 solution514 = new Solution514();

    @Test
    public void example1() {
        String ring = "godding";
        String key = "gd";
        int expected = 4;
        Assertions.assertEquals(expected, solution514.findRotateSteps(ring, key));
    }

    @Test
    public void example2() {
        String ring = "godding";
        String key = "godding";
        int expected = 13;
        Assertions.assertEquals(expected, solution514.findRotateSteps(ring, key));
    }
}