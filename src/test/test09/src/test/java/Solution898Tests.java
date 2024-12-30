import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution898Tests {
    private final Solution898 solution898 = new Solution898();

    @Test
    public void example1() {
        int[] arr = {0};
        int expected = 1;
        Assertions.assertEquals(expected, solution898.subarrayBitwiseORs(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution898.subarrayBitwiseORs(arr));
    }

    @Test
    public void example3() {
        int[] arr = {1, 2, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution898.subarrayBitwiseORs(arr));
    }
}
