import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String ans = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((x, y) -> (y + x).compareTo(x + y))
                .collect(Collectors.joining());
        // 去掉前缀 0
        int st = 0;
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') {
                return ans.substring(st);
            }
        }
        return "0";
    }

    public String largestNumber2(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.sort((o1, o2) -> {
            long s1 = 10;
            long s2 = 10;
            while (s1 <= o1) {
                s1 *= 10;
            }
            while (s2 <= o2) {
                s2 *= 10;
            }
            return Long.compare(s1 * o2 + o1, s2 * o1 + o2);
        });

        if (list.get(0).equals(0)) {
            return "0";
        }

        // List<Integer> => String
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : list) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
/*
179. 最大数
https://leetcode.cn/problems/largest-number/

给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 10^9

贪心。
 */