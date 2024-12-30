import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1704Tests {
    private final Solution1704 solution1704 = new Solution1704();

    @Test
    public void example1() {
        String s = "book";
        Assertions.assertTrue(solution1704.halvesAreAlike(s));
    }

    @Test
    public void example2() {
        String s = "textbook";
        Assertions.assertFalse(solution1704.halvesAreAlike(s));
    }
}
