public class SolutionP1570 {
    static class SparseVector {
        private final int[] nums;

        SparseVector(int[] nums) {
            this.nums = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] * vec.nums[i];
            }
            return sum;
        }
    }
}
/*
$1570. 两个稀疏向量的点积
https://leetcode.cn/problems/dot-product-of-two-sparse-vectors/

给定两个稀疏向量，计算它们的点积（数量积）。
实现类 SparseVector：
- SparseVector(nums) 以向量 nums 初始化对象。
- dotProduct(vec) 计算此向量与 vec 的点积。
稀疏向量 是指绝大多数分量为 0 的向量。你需要 高效 地存储这个向量，并计算两个稀疏向量的点积。
进阶：当其中只有一个向量是稀疏向量时，你该如何解决此问题？
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
0 <= nums1[i], nums2[i] <= 100

模拟。
 */