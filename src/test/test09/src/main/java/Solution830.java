import java.util.ArrayList;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        // s 仅含小写英文字母。末位补 0 防止越界
        s = s + "0";
        List<List<Integer>> ans = new ArrayList<>();
        // 双指针
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // 字符相等 右指针往右移
            if (s.charAt(left) == s.charAt(right)) {
                right++;
            }
            // 字符不等 计算差值，若大于等于 3 则进行记录
            else {
                int between = right - left;
                if (between >= 3) {
                    // jdk11
                    List<Integer> beginEnd = List.of(left, right - 1);
                    ans.add(beginEnd);
                }
                // 左指针移至右指针位置
                left = right;
            }
        }
        return ans;
    }
}
/*
830. 较大分组的位置
https://leetcode.cn/problems/positions-of-large-groups/

第 83 场周赛 T1。

在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
提示：
1 <= s.length <= 1000
s 仅含小写英文字母

类双指针。末位补 0 防止越界。注意 List.of() 写法
 */