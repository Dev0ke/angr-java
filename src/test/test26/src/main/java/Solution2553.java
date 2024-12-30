import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2553 {
    public int[] separateDigits(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            int x = nums[i];
            while (x > 0) {
                int d = x % 10;
                list.add(d);
                x /= 10;
            }
        }
        Collections.reverse(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
/*
2553. 分割数组中数字的数位
https://leetcode.cn/problems/separate-the-digits-in-an-array/

第 97 场双周赛 T1。

给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。
对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。
- 比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^5

模拟
相似题目: 2544. 交替数字和
https://leetcode.cn/problems/alternating-digit-sum/
 */