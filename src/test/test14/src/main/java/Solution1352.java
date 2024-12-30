public class Solution1352 {
    static class ProductOfNumbers {
        private static final int N = 40010;
        private final int[] preProduct;
        private int idx;

        public ProductOfNumbers() {
            preProduct = new int[N];
            preProduct[0] = 1;
            idx = 0;
        }

        public void add(int num) {
            if (num == 0) {
                idx = 0;
            } else {
                idx++;
                preProduct[idx] = num;
                preProduct[idx] *= preProduct[idx - 1];
            }
        }

        public int getProduct(int k) {
            if (idx < k) {
                return 0;
            }
            return preProduct[idx] / preProduct[idx - k];
        }
    }
}
/*
1352. 最后 K 个数的乘积
https://leetcode.cn/problems/product-of-the-last-k-numbers/

请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
1. add(int num)
 - 将数字 num 添加到当前数字列表的最后面。
2. getProduct(int k)
 - 返回当前数字列表中，最后 k 个数字的乘积。
 - 你可以假设当前列表中始终 至少 包含 k 个数字。
题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
提示：
add 和 getProduct 两种操作加起来总共不会超过 40000 次。
0 <= num <= 100
1 <= k <= 40000

前缀和思想，"前缀积"。
 */