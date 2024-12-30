import java.util.HashSet;
import java.util.Set;

public class Solution2154 {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        while (hashSet.contains(original)) {
            original *= 2;
        }
        return original;
    }
}
/*
2154. 将找到的值乘以 2
https://leetcode.cn/problems/keep-multiplying-found-values-by-two/

第 278 场周赛 T1。

给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
接下来，你需要按下述步骤操作：
1.如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
2.否则，停止这一过程。
3.只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
返回 original 的 最终 值。

2022 牛年最后一场周赛，工作日。开赛后 3min T1 WA 了一发后被叫去开会。直接掉出 knight（1903 => 1841）。。
模拟题。
 */