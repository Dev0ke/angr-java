import java.util.Arrays;

public class Solution1093 {
    public double[] sampleStats(int[] count) {
        int n = count.length;
        double[] ans = new double[5];
        // 样本中的最小元素
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                ans[0] = i;
                break;
            }
        }
        // 样品中的最大元素
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] > 0) {
                ans[1] = i;
                break;
            }
        }
        // 样本的平均值
        int tot = Arrays.stream(count).sum();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) count[i] * i;
        }
        ans[2] = sum / tot;
        // 中位数
        int median = 0;
        int cnt = 0;
        int l = (tot + 1) / 2, r = (tot + 2) / 2;
        for (int i = 0; i < n; i++) {
            if (cnt < r && cnt + count[i] >= r) median += i;
            if (cnt < l && cnt + count[i] >= l) median += i;
            cnt += count[i];
        }
        ans[3] = median / 2.0;
        // 样本中出现次数最多的数字
        int max_cnt = 0;
        for (int i = 0; i < n; i++) {
            if (max_cnt < count[i]) {
                max_cnt = count[i];
                ans[4] = i;
            }
        }
        return ans;
    }
}
/*
1093. 大样本统计
https://leetcode.cn/problems/statistics-from-a-large-sample/description/

我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 在样本中出现的次数。
计算以下统计数据:
- minimum ：样本中的最小元素。
- maximum ：样品中的最大元素。
- mean ：样本的平均值，计算为所有元素的总和除以元素总数。
- median ：
  - 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。
  - 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。
- mode ：样本中出现次数最多的数字。保众数是 唯一 的。
以浮点数数组的形式返回样本的统计信息 [minimum, maximum, mean, median, mode] 。与真实答案误差在 10^-5 内的答案都可以通过。
提示：
count.length == 256
0 <= count[i] <= 10^9
1 <= sum(count) <= 10^9
 count 的众数是 唯一 的

模拟。
主要考察如何找中位数。
时间复杂度 O(n)。
 */