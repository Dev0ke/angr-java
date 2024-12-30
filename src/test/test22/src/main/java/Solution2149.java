import java.util.ArrayList;
import java.util.List;

public class Solution2149 {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> gt0List = new ArrayList<>();
        List<Integer> lt0List = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                gt0List.add(num);
            } else {
                lt0List.add(num);
            }
        }

        List<Integer> resList = new ArrayList<>();
        int len = gt0List.size();
        for (int i = 0; i < len; i++) {
            resList.add(gt0List.get(i));
            resList.add(lt0List.get(i));
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
2149. 按符号重排数组
https://leetcode.cn/problems/rearrange-array-elements-by-sign/

第 277 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums ，数组长度为 偶数 ，由数目相等的正整数和负整数组成。
你需要 重排 nums 中的元素，使修改后的数组满足下述条件：
任意 连续 的两个整数 符号相反
1.对于符号相同的所有整数，保留 它们在 nums 中的 顺序 。
2.重排后数组以正整数开头。
3.重排元素满足上述条件后，返回修改后的数组。
提示：
2 <= nums.length <= 2 * 10^5
nums.length 是 偶数
1 <= |nums[i]| <= 10^5
nums 由 相等 数量的正整数和负整数组成

模拟。
时间复杂度 O(n)
 */