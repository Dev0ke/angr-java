import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution703Tests {
    @Test
    public void example1() {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        Solution703.KthLargest kthLargest = new Solution703.KthLargest(k, nums);
        // return 4
        Assertions.assertEquals(4, kthLargest.add(3));
        // return 5
        Assertions.assertEquals(5, kthLargest.add(5));
        // return 5
        Assertions.assertEquals(5, kthLargest.add(10));
        // return 8
        Assertions.assertEquals(8, kthLargest.add(9));
        // return 8
        Assertions.assertEquals(8, kthLargest.add(4));
    }
}
