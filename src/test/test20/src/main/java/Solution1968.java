import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1968 {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (!checkList(numsList)) {
            Collections.shuffle(numsList);
        }
        // List<Integer> to int[]
        int[] res = new int[numsList.size()];
        for (int i = 0; i < numsList.size(); i++) {
            res[i] = numsList.get(i);
        }
        return res;
    }

    private boolean checkList(List<Integer> numsList) {
        int len = numsList.size();
        for (int i = 1; i < len - 1; i++) {
            if (numsList.get(i - 1) + numsList.get(i + 1) == numsList.get(i) + numsList.get(i)) {
                return false;
            }
        }
        return true;
    }
}
/*
1968. 构造元素不等于两相邻元素平均值的数组
https://leetcode.cn/problems/array-with-elements-not-equal-to-average-of-neighbors/

第 254 场周赛 T2。

给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两侧相邻元素的 平均值 。
更公式化的说法是，重新排列的数组应当满足这一属性：对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + nums[i+1]) / 2 不等于 nums[i] 均成立 。
返回满足题意的任一重排结果。
提示：
3 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

取巧方法：洗牌算法 java Collections#shuffle(List<?> list) 满足要求的返回即可。
正规方法：先进行排序 时间复杂度 O(nlogn)
可以将数值较小的第一部分的元素放入重排数组的偶数下标（包含 0），并将数值较大的第二部分的元素放入重排数组的奇数下标。
本题的 UT 写法，可以考虑穷举所有合法答案，看是否包含；亦或者用自定义函数进行校验。
 */