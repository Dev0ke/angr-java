public class SolutionP1538 {
    //
    public int guessMajority(ArrayReader reader) {
        // nums[0] = 0
        int cnt0 = 1, cnt1 = 0;
        int q0234 = reader.query(0, 2, 3, 4);
        int q1234 = reader.query(1, 2, 3, 4);
        // 从 start 开始每两个数一查
        int start, p, q;
        // 记录任意一个 0/1 的位置
        int where0 = -1, where1 = -1;
        if (q0234 == q1234) {
            // nums[1] = 0
            ++cnt0;
            start = 2;
            p = 0;
            q = 1;
            where0 = 0;
        } else {
            // nums[1] = 1
            ++cnt1;
            int q0134 = reader.query(0, 1, 3, 4);
            if (q0134 == q1234) {
                // nums[2] = 0
                ++cnt0;
                start = 3;
                p = 0;
                q = 2;
                where0 = 0;
                where1 = 1;
            } else {
                // nums[2] = 1，为了方便后续编码可以交换一下
                // 即 nums[0] = 1, nums[1] = nums[2] = 0
                cnt0 = 2;
                cnt1 = 1;
                start = 3;
                p = 1;
                q = 2;
                where0 = 1;
                where1 = 0;
            }
        }

        // 目前为止，0 的个数多于 1 的个数，如果在接下来的查找中没有出现两个 1 的情况（即返回值为 0），那么 1 的个数一定小于等于 0
        // 因此在出现了两个 1 的时候再记录 1 的位置也不迟
        int n = reader.length();
        int i, curr;
        for (i = start; i + 1 < n; i += 2) {
            curr = reader.query(p, q, i, i + 1);
            if (curr == 0) {
                cnt1 += 2;
                if (where1 == -1) {
                    where1 = i;
                }
            } else if (curr == 2) {
                ++cnt0;
                ++cnt1;
            } else {
                cnt0 += 2;
            }
        }

        if (i != n) {
            int q0123 = reader.query(0, 1, 2, 3);
            int extra = reader.query(1, 2, 3, n - 1);
//            int status = (q0123 == extra) ^ (p == 0);
            boolean status = (q0123 == extra) ^ (p == 0);
            if (!status) {
                ++cnt0;
            } else {
                ++cnt1;
            }
        }

        if (cnt0 == cnt1) {
            return -1;
        }
        return cnt0 < cnt1 ? where1 : where0;
    }

    // UT
    interface ArrayReader {
        // Compares 4 different elements in the array
        // return 4 if the values of the 4 elements are the same (0 or 1).
        // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
        // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.
        public int query(int a, int b, int c, int d);

        // Returns the length of the array
        public int length();
    }
}
/*
$1538. 找出隐藏数组中出现次数最多的元素
https://leetcode.cn/problems/guess-the-majority-in-a-hidden-array/description/

给定一个整数数组 nums，且 nums 中的所有整数都为 0 或 1。你不能直接访问这个数组，你需要使用 API ArrayReader ，该 API 含有下列成员函数：
- int query(int a, int b, int c, int d)：其中 0 <= a < b < c < d < ArrayReader.length() 。此函数查询以这四个参数为下标的元素并返回：
  - 4 : 当这四个元素相同（0 或 1）时。
  - 2 : 当其中三个元素的值等于 0 且一个元素等于 1 时，或当其中三个元素的值等于 1 且一个元素等于 0 时。
  - 0 : 当其中两个元素等于 0 且两个元素等于 1 时。
- int length()：返回数组的长度。
你可以调用 query() 最多 2 * n 次，其中 n 等于 ArrayReader.length()。
返回 nums 中出现次数最多的值的任意索引，若所有的值出现次数均相同，返回 -1。
提示:
5 <= nums.length <= 10^5
0 <= nums[i] <= 1
进阶：要找到出现次数最多的元素，需要至少调用 query() 多少次？

只查询必要的信息
https://leetcode.cn/problems/guess-the-majority-in-a-hidden-array/solutions/363747/san-chong-fang-fa-you-yi-dao-nan-by-zerotrac2/
实际上我们并没有必要复原整个数组，如果我们知道位置 p 和 q 的数相等（假设均为 1），那么我们可以一次性查询两个新的数 x, y：
- 果查询结果为 0，说明 x, y 均为 0；
- 果查询结果为 2，说明 x, y 其中一个为 0，另一个为 1；
- 果查询结果为 4，说明 x, y 均为 1。
这样我们虽然不能复原数组，但仍然可以求出数组中 0 和 1 的个数。如果最后还剩一个数，那么额外加两次查询判断其与位置 0 的数是否相等即可。
那么如何找出 p 和 q 呢？根据鸽巢原理，前三个数中一定有两个数是相等的，因此我们可以使用之前判断两个数是否相等的方法找出 p 和 q。
 */