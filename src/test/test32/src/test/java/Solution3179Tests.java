import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3179Tests {
    private final Solution3179 solution3179 = new Solution3179();

    @Test
    public void example1() {
        int n = 4;
        int k = 5;
        int expected = 56;
        Assertions.assertEquals(expected, solution3179.valueAfterKSeconds(n, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int k = 3;
        int expected = 35;
        Assertions.assertEquals(expected, solution3179.valueAfterKSeconds(n, k));
    }
}