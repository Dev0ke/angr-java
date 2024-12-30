import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution307Tests {
    @Test
    public void example1() {
        Solution307.NumArray numArray = new Solution307.NumArray(new int[]{1, 3, 5});
        // 返回 1 + 3 + 5 = 9
        Assertions.assertEquals(9, numArray.sumRange(0, 2));
        // nums = [1,2,5]
        numArray.update(1, 2);
        // 返回 1 + 2 + 5 = 8
        Assertions.assertEquals(8, numArray.sumRange(0, 2));
    }

    @Test
    public void example2() {
        Solution307.NumArray2 numArray = new Solution307.NumArray2(new int[]{1, 3, 5});
        // 返回 1 + 3 + 5 = 9
        Assertions.assertEquals(9, numArray.sumRange(0, 2));
        // nums = [1,2,5]
        numArray.update(1, 2);
        // 返回 1 + 2 + 5 = 8
        Assertions.assertEquals(8, numArray.sumRange(0, 2));
    }
}
