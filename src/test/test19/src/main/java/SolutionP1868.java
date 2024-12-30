import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int n = encoded1.length;
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n) {
            int minFreq = Math.min(encoded1[i][1], encoded2[j][1]);
            int prod = encoded1[i][0] * encoded2[j][0];
            if (!ans.isEmpty() && ans.get(ans.size() - 1).get(0) == prod) {
                Integer lastFreq = ans.get(ans.size() - 1).get(1);
                ans.get(ans.size() - 1).set(1, lastFreq + minFreq);
            } else {
//                ans.add(List.of(prod, minFreq));
                ans.add(Arrays.asList(prod, minFreq));
            }
            encoded1[i][1] -= minFreq;
            encoded2[j][1] -= minFreq;
            if (encoded1[i][1] == 0) i++;
            if (encoded2[j][1] == 0) j++;
        }
        return ans;
    }
}
/*
$1868. 两个行程编码数组的积
https://leetcode.cn/problems/product-of-two-run-length-encoded-arrays/description/

行程编码（Run-length encoding）是一种压缩算法，能让一个含有许多段连续重复数字的整数类型数组 nums 以一个（通常更小的）二维数组 encoded 表示。每个 encoded[i] = [vali, freqi] 表示 nums 中第 i 段重复数字，其中 vali 是该段重复数字，重复了 freqi 次。
- 例如， nums = [1,1,1,2,2,2,2,2] 可表示称行程编码数组 encoded = [[1,3],[2,5]] 。对此数组的另一种读法是“三个 1 ，后面有五个 2 ”。
两个行程编码数组 encoded1 和 encoded2 的积可以按下列步骤计算：
1.将 encoded1 和 encoded2 分别扩展成完整数组 nums1 和 nums2 。
2.创建一个新的数组 prodNums ，长度为 nums1.length 并设 prodNums[i] = nums1[i] * nums2[i] 。
3.将 prodNums 压缩成一个行程编码数组并返回之。
给定两个行程编码数组 encoded1 和 encoded2 ，分别表示完整数组 nums1 和 nums2 。nums1 和 nums2 的长度相同。 每一个 encoded1[i] = [vali, freqi] 表示 nums1 中的第 i 段，每一个 encoded2[j] = [valj, freqj] 表示 nums2 中的第 j 段。
返回 encoded1 和 encoded2 的乘积。
注：行程编码数组需压缩成可能的最小长度。
提示：
1 <= encoded1.length, encoded2.length <= 10^5
encoded1[i].length == 2
encoded2[j].length == 2
对于每一个 encoded1[i]， 1 <= vali, freqi <= 10^4
对于每一个 encoded2[j]， 1 <= valj, freqj <= 10^4
encoded1 和 encoded2 表示的完整数组长度相同。

双指针。
 */