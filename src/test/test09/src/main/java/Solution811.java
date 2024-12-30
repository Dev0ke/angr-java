import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] ss = cpdomain.split(" ");
            int rep = Integer.parseInt(ss[0]);
            String d = ss[1];
            cntMap.put(d, cntMap.getOrDefault(d, 0) + rep);
            int idx = d.indexOf(".");
            while (idx >= 0) {
                d = d.substring(idx + 1);
                cntMap.put(d, cntMap.getOrDefault(d, 0) + rep);
                idx = d.indexOf(".");
            }
        }

        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            resList.add(entry.getValue() + " " + entry.getKey());
        }
        return resList;
    }
}
/*
811. 子域名访问计数
https://leetcode.cn/problems/subdomain-visit-count/

网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。
当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
- 例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。
提示：
1 <= cpdomain.length <= 100
1 <= cpdomain[i].length <= 100
cpdomain[i] 会遵循 "repi d1i.d2i.d3i" 或 "repi d1i.d2i" 格式
repi 是范围 [1, 104] 内的一个整数
d1i、d2i 和 d3i 由小写英文字母组成

字符串截取 + HashMap 模拟。
 */