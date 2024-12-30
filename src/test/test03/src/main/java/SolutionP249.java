import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String s : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
                stringBuilder.append(diff).append(":");
            }
            hashMap.computeIfAbsent(stringBuilder.toString(), key -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }
}
/*
$249. 移位字符串分组
https://leetcode.cn/problems/group-shifted-strings/

给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。
这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
"abc" -> "bcd" -> ... -> "xyz"
给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。

相同分组的字符串 相邻字母的间隔差是固定的。HashMap 统计即可。
 */