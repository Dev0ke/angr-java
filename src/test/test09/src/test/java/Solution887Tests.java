import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution887Tests {
    private final Solution887 solution887 = new Solution887();

    @Test
    public void example1() {
        int k = 1;
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution887.superEggDrop(k, n));
    }

    @Test
    public void example2() {
        int k = 2;
        int n = 6;
        int expected = 3;
        Assertions.assertEquals(expected, solution887.superEggDrop(k, n));
    }

    @Test
    public void example3() {
        int k = 3;
        int n = 14;
        int expected = 4;
        Assertions.assertEquals(expected, solution887.superEggDrop(k, n));
    }
}
