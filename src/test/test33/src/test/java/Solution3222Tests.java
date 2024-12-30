import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3222Tests {
    private final Solution3222 solution3222 = new Solution3222();

    @Test
    public void example1() {
        int x = 2;
        int y = 7;
        String expected = "Alice";
        Assertions.assertEquals(expected, solution3222.losingPlayer(x, y));
        Assertions.assertEquals(expected, solution3222.losingPlayer2(x, y));
    }

    @Test
    public void example2() {
        int x = 4;
        int y = 11;
        String expected = "Bob";
        Assertions.assertEquals(expected, solution3222.losingPlayer(x, y));
        Assertions.assertEquals(expected, solution3222.losingPlayer2(x, y));
    }
}