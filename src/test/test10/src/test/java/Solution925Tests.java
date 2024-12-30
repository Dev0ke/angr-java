import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution925Tests {
    private final Solution925 solution925 = new Solution925();

    @Test
    public void example1() {
        String name = "alex";
        String typed = "aaleex";
        Assertions.assertTrue(solution925.isLongPressedName(name, typed));
    }

    @Test
    public void example2() {
        String name = "saeed";
        String typed = "ssaaedd";
        Assertions.assertFalse(solution925.isLongPressedName(name, typed));
    }
}