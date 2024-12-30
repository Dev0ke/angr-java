import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution60Tests {
    private final Solution60.V1 solution60_v1 = new Solution60.V1();
    private final Solution60.V2 solution60_v2 = new Solution60.V2();

    @Test
    public void example1() {
        int n = 3;
        int k = 3;
        String expected = "213";
        Assertions.assertEquals(expected, solution60_v1.getPermutation(n, k));
        Assertions.assertEquals(expected, solution60_v2.getPermutation(n, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int k = 9;
        String expected = "2314";
        Assertions.assertEquals(expected, solution60_v1.getPermutation(n, k));
        Assertions.assertEquals(expected, solution60_v2.getPermutation(n, k));
    }

    @Test
    public void example3() {
        int n = 3;
        int k = 1;
        String expected = "123";
        Assertions.assertEquals(expected, solution60_v1.getPermutation(n, k));
        Assertions.assertEquals(expected, solution60_v2.getPermutation(n, k));
    }
}
