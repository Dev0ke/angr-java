import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1865Tests {
    @Test
    public void example1() {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};
        Solution1865.FindSumPairs findSumPairs = new Solution1865.FindSumPairs(nums1, nums2);

        // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
        Assertions.assertEquals(8, findSumPairs.count(7));

        // 此时 nums2 = [1,4,5,4,5,4]
        findSumPairs.add(3, 2);

        // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
        Assertions.assertEquals(2, findSumPairs.count(8));

        // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
        Assertions.assertEquals(1, findSumPairs.count(4));

        // 此时 nums2 = [2,4,5,4,5,4]
        findSumPairs.add(0, 1);

        // 此时 nums2 = [2,5,5,4,5,4]
        findSumPairs.add(1, 1);

        // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
        Assertions.assertEquals(11, findSumPairs.count(7));
    }
}