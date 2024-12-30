import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution753Tests {
    private final Solution753 solution753 = new Solution753();

    @Test
    public void example1() {
        int n = 1;
        int k = 2;
        String expected = "10";
        Assertions.assertEquals(expected, solution753.crackSafe(n, k));
        Assertions.assertEquals(expected, solution753.crackSafe2(n, k));
    }

    @Test
    public void example2() {
        int n = 2;
        int k = 2;
        String expected = "01100";
        Assertions.assertEquals(expected, solution753.crackSafe(n, k));
        Assertions.assertEquals(expected, solution753.crackSafe2(n, k));
    }
}
