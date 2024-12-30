import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution771Tests {
    private final Solution771 solution771 = new Solution771();

    @Test
    public void example1() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int expected = 3;
        Assertions.assertEquals(expected, solution771.numJewelsInStones(jewels, stones));
    }

    @Test
    public void example2() {
        String jewels = "z";
        String stones = "ZZ";
        int expected = 0;
        Assertions.assertEquals(expected, solution771.numJewelsInStones(jewels, stones));
    }
}