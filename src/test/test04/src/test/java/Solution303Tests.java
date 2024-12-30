import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution303Tests {
    @Test
    public void example1() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Solution303.NumArray numArray = new Solution303.NumArray(nums);
        // return 1 ((-2) + 0 + 3)
        Assertions.assertEquals(1, numArray.sumRange(0, 2));
        // return -1 (3 + (-5) + 2 + (-1))
        Assertions.assertEquals(-1, numArray.sumRange(2, 5));
        // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
        Assertions.assertEquals(-3, numArray.sumRange(0, 5));
    }
}
