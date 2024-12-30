import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2266Tests {
    private final Solution2266 solution2266 = new Solution2266();

    @Test
    public void example1() {
        String pressedKeys = "22233";
        int expected = 8;
        Assertions.assertEquals(expected, solution2266.countTexts(pressedKeys));
    }

    @Test
    public void example2() {
        String pressedKeys = "222222222222222222222222222222222222";
        int expected = 82876089;
        Assertions.assertEquals(expected, solution2266.countTexts(pressedKeys));
    }
}
