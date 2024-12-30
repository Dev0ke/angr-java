import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        // 离散化
        int[] yArr = getDiscrete(nums);

        Fenwick fenwick = new Fenwick(yArr.length);
        List<Integer> resList = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int yId = getId(yArr, nums[i]);
            fenwick.add(yId, 1);
            resList.add(fenwick.getSum(yId - 1));
        }
        Collections.reverse(resList);
        return resList;
    }

    private int[] getDiscrete(int[] xArr) {
        Set<Integer> set = new HashSet<>();
        for (int x : xArr) {
            set.add(x);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (Integer x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    private int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x) + 1;
    }

    private static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return x & -x;
        }

        public void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        public int getSum(int x) {
            int ans = 0;
            while (x >= 1) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
315. 计算右侧小于当前元素的个数
https://leetcode.cn/problems/count-of-smaller-numbers-after-self/

给定一个整数数组 nums，按要求返回一个新数组counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

树状数组。
nums = [3,9,5,2,6,1,3] 后往前遍历，转化为前缀和
桶 1 2 3 4 5 6 7 8 9
   0 0 1 0 0 0 0 0 0 [0]
   1 0 1 0 0 0 0 0 0 [0,0]
   1 0 1 0 0 1 0 0 0 [2,0,0]
   1 1 1 0 0 1 0 0 0 [1,2,0,0]
   1 1 1 0 1 1 0 0 0 [3,1,2,0,0]
   1 1 1 0 1 1 0 0 1 [5,3,1,2,0,0]
   1 1 2 0 1 1 0 0 1 [2,5,3,1,2,0,0]
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 剑指 Offer 51. 数组中的逆序对
https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */