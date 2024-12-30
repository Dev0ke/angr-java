public class Solution3076 {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int m = arr[i].length();
            String res = "";
            // 子串长度
            for (int L = 1; L <= m; L++) {
                for (int st = 0; st + L <= m; st++) {
                    String sub = arr[i].substring(st, st + L);
                    if ((res.isEmpty() || sub.compareTo(res) < 0) && check(arr, i, sub)) {
                        res = sub;
                    }
                }
                if (!res.isEmpty()) break;
            }
            ans[i] = res;
        }
        return ans;
    }

    private boolean check(String[] arr, int i, String sub) {
        for (int j = 0; j < arr.length; j++) {
            if (j != i && arr[j].contains(sub)) {
                return false;
            }
        }
        return true;
    }
}
/*
3076. 数组中的最短非公共子字符串
https://leetcode.cn/problems/shortest-uncommon-substring-in-an-array/description/

第 388 场周赛 T3。

给你一个数组 arr ，数组中有 n 个 非空 字符串。
请你求出一个长度为 n 的字符串 answer ，满足：
- answer[i] 是 arr[i] 最短 的子字符串，且它不是 arr 中其他任何字符串的子字符串。如果有多个这样的子字符串存在，answer[i] 应该是它们中字典序最小的一个。如果不存在这样的子字符串，answer[i] 为空字符串。
请你返回数组 answer 。
提示：
n == arr.length
2 <= n <= 100
1 <= arr[i].length <= 20
arr[i] 只包含小写英文字母。

暴力
时间复杂度 O(n^2 * m^4)
 */