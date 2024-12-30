import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP248 {
    public int strobogrammaticInRange(String low, String high) {
        int lowLen = low.length();
        int highLen = high.length();
        int res = 0;
        if (lowLen == highLen) {
            for (String x : findStrobogrammatic(lowLen)) {
                if (low.compareTo(x) <= 0 && x.compareTo(high) <= 0) {
                    res++;
                }
            }
        } else {
            for (String x : findStrobogrammatic(lowLen)) {
                if (low.compareTo(x) <= 0) {
                    res++;
                }
            }
            for (int i = lowLen + 1; i <= highLen - 1; i++) {
                res += findStrobogrammatic(i).size();
            }
            for (String x : findStrobogrammatic(highLen)) {
                if (x.compareTo(high) <= 0) {
                    res++;
                }
            }
        }
        return res;
    }

    private List<String> findStrobogrammatic(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1", "8");
        } else if (n == 2) {
            return Arrays.asList("11", "69", "88", "96");
        } else {
            Map<Integer, List<String>> hashMap = new HashMap<>();
            hashMap.put(0, new ArrayList<>());
            hashMap.put(1, Arrays.asList("0", "1", "8"));
            hashMap.put(2, Arrays.asList("00", "11", "69", "88", "96"));
            for (int i = 3; i <= n; i++) {
                // n-2
                List<String> lastList = hashMap.get(i - 2);
                List<String> curList = new ArrayList<>();
                for (String middleStr : lastList) {
                    if (i != n) {
                        curList.add("0" + middleStr + "0");
                    }
                    curList.add("1" + middleStr + "1");
                    curList.add("8" + middleStr + "8");
                    curList.add("6" + middleStr + "9");
                    curList.add("9" + middleStr + "6");
                }
                hashMap.put(i, curList);
            }
            return hashMap.get(n);
        }
    }
}
/*
$248. 中心对称数 III
https://leetcode.cn/problems/strobogrammatic-number-iii/

给定两个字符串 low 和 high 表示两个整数 low 和 high ，其中 low <= high ，返回 范围 [low, high] 内的 「中心对称数」总数  。
中心对称数 是一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
提示:
1 <= low.length, high.length <= 15
low 和 high 只包含数字
low <= high
low and high 不包含任何前导零，除了零本身。

在 247 题基础上加个范围统计
相似题目: $246. 中心对称数
https://leetcode.cn/problems/strobogrammatic-number/
$247. 中心对称数 II
https://leetcode.cn/problems/strobogrammatic-number-ii/
 */