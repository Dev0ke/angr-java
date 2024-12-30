import java.util.ArrayList;
import java.util.List;

public class SolutionP163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<Integer> list = new ArrayList<>();
        list.add(lower - 1);
        for (int num : nums) {
            list.add(num);
        }
        list.add(upper + 1);

        List<String> resList = new ArrayList<>();
        for (int i = 0; i + 1 < list.size(); i++) {
            if (!list.get(i).equals(list.get(i + 1) - 1)) {
                int left = list.get(i) + 1;
                int right = list.get(i + 1) - 1;
                if (left == right) {
                    resList.add(String.valueOf(left));
                } else {
                    resList.add(left + "->" + right);
                }
            }
        }
        return resList;
    }
}
/*
$163. 缺失的区间
https://leetcode.cn/problems/missing-ranges/

给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
示例：
输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
输出: ["2", "4->49", "51->74", "76->99"]

注意边界处理
 */