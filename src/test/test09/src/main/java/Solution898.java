import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> ors = new HashSet<>();
        for (int x : arr) {
            ors = ors.stream().map(o -> o | x).collect(Collectors.toSet());
            ors.add(x);
            ans.addAll(ors);
        }
        return ans.size();
    }
}
/*
898. 子数组按位或操作
https://leetcode.cn/problems/bitwise-ors-of-subarrays/

我们有一个非负整数数组 arr 。
对于每个（连续的）子数组 sub = [arr[i], arr[i + 1], ..., arr[j]] （ i <= j），我们对 sub 中的每个元素进行按位或操作，获得结果 arr[i] | arr[i + 1] | ... | arr[j] 。
返回可能结果的数量。 多次出现的结果在最终答案中仅计算一次。
提示：
1 <= nums.length <= 5 * 10^4
0 <= nums[i] <= 10^9

集合
相似题目: 1521. 找到最接近目标值的函数值
https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 */