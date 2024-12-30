import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2810Tests {
    private final Solution2810 solution2810 = new Solution2810();

    @Test
    public void example1() {
        String s = "string";
        String expected = "rtsng";
        Assertions.assertEquals(expected, solution2810.finalString(s));
    }

    @Test
    public void example2() {
        String s = "poiinter";
        String expected = "ponter";
        Assertions.assertEquals(expected, solution2810.finalString(s));
    }
}