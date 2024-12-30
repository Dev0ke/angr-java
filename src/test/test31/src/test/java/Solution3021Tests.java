import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3021Tests {
    private final Solution3021 solution3021 = new Solution3021();

    @Test
    public void example1() {
        int n = 3;
        int m = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution3021.flowerGame(n, m));
    }

    @Test
    public void example2() {
        int n = 1;
        int m = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution3021.flowerGame(n, m));
    }
}