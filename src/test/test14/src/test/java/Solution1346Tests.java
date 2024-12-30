import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1346Tests {
    private final Solution1346 solution1346 = new Solution1346();

    @Test
    public void example1() {
        int[] arr = {10, 2, 5, 3};
        Assertions.assertTrue(solution1346.checkIfExist(arr));
    }

    @Test
    public void example2() {
        int[] arr = {7, 1, 14, 11};
        Assertions.assertTrue(solution1346.checkIfExist(arr));
    }

    @Test
    public void example3() {
        int[] arr = {3, 1, 7, 11};
        Assertions.assertFalse(solution1346.checkIfExist(arr));
    }
}
