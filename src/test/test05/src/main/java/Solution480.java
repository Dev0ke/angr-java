import java.util.TreeMap;

public class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MultiSets multiSets = new MultiSets(k, k / 2);

        for (int i = 0; i < k; i++) {
            multiSets.add(nums[i]);
        }
        double[] ans = new double[n - k + 1];
        ans[0] = multiSets.median();
        for (int i = k; i < n; i++) {
            multiSets.add(nums[i]);
            multiSets.del(nums[i - k]);
            ans[i - k + 1] = multiSets.median();
        }
        return ans;
    }

    private static class MultiSets {
        int n, k;
        TreeMap<Integer, Integer> xMap, yMap;
        int xsz, ysz;

        // n:窗口大小, k:第 k 大
        public MultiSets(int n, int k) {
            this.n = n;
            this.k = k;
            this.xMap = new TreeMap<>();
            this.yMap = new TreeMap<>();
            this.xsz = 0;
            this.ysz = 0;
        }

        private void add(int v) {
            yInsertV(v);
            balance();
        }

        private void del(int v) {
            if (xMap.containsKey(v)) {
                xEraseV(v);
            } else {
                yEraseV(v);
            }
            balance();
        }

        // k:窗口大小
        double median() {
            Integer y = yMap.lastKey();
            if (n % 2 == 0) {
                long x = xMap.firstKey();
                return x + (y - x) / 2.0;
            } else {
                return y;
            }
        }

        private void balance() {
            if (xsz + ysz < n) return;
            while (xsz < k) {
                int iy = yMap.lastKey();
                yEraseV(iy);
                xInsertV(iy);
            }
            if (xsz == 0 || ysz == 0) return;
            while (true) {
                int ix = xMap.firstKey();
                int iy = yMap.lastKey();
                if (ix >= iy) break;
                xEraseV(ix);
                yEraseV(iy);
                xInsertV(iy);
                yInsertV(ix);
            }
        }

        private void xInsertV(int v) {
            xMap.put(v, xMap.getOrDefault(v, 0) + 1);
            xsz++;
        }

        private void yInsertV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) + 1);
            ysz++;
        }

        private void xEraseV(int v) {
            xMap.put(v, xMap.getOrDefault(v, 0) - 1);
            if (xMap.get(v) == 0) xMap.remove(v);
            xsz--;
        }

        private void yEraseV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) - 1);
            if (yMap.get(v) == 0) yMap.remove(v);
            ysz--;
        }
    }
}
/*
480. 滑动窗口中位数
https://leetcode.cn/problems/sliding-window-median/description/

中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
例如：
[2,3,4]，中位数是 3
[2,3]，中位数是 (2 + 3) / 2 = 2.5
给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
提示：
你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。

对顶堆 / 双平衡树。
时间复杂度 O(nlogn)
```cpp
class Solution {
private:
    int sz, k;
    multiset<int> x, y;

    void balance() {
        if (x.size() + y.size() < sz)return;
        while (x.size() < k) {
            auto iy = y.end();
            iy--;
            x.insert((*iy));
            y.erase(iy);
        }
        if (x.empty() || y.empty()) { return; }
        while (true) {
            auto ix = x.begin();
            auto iy = y.end();
            iy--;
            int ex = (*ix);
            int ey = (*iy);
            if (ex >= ey) { break; }
            x.erase(ix);
            y.erase(iy);
            x.insert(ey);
            y.insert(ex);
        }
    }

    void add(int v) {
        y.insert(v);
        balance();
    }

    void erase(int v) {
        auto ix = x.find(v);
        if (ix != x.end()) {
            x.erase(ix);
        } else {
            y.erase(y.find(v));
        }
        balance();
    }

    double median() {
        auto iy = y.end();
        iy--;
        int ey = (*iy);
        if (sz % 2) {
            return ey;
        } else {
            auto ix = x.begin();
            long ex = (*ix);
            return (ex + ey) / 2.0;
        }
    }

public:
    vector<double> medianSlidingWindow(vector<int> &nums, int k) {
        int n = nums.size();
        this->sz = k;
        this->k = k / 2;

        for (int i = 0; i < k; ++i) {
            add(nums[i]);
        }
        vector<double> ans(n - k + 1);
        ans[0] = median();
        for (int i = k; i < n; ++i) {
            add(nums[i]);
            erase(nums[i - k]);
            ans[i - k + 1] = median();
        }
        return ans;
    }
};
```
 */