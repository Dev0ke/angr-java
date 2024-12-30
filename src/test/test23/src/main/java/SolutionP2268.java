import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP2268 {
    public int minimumKeypresses(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(counter.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        int ans = 0;
        for (int i = 0; i < entries.size(); i++) {
            int group = (i / 9) + 1;
            ans += group * entries.get(i).getValue();
        }
        return ans;
    }
}
/*
$2268. 最少按键次数
https://leetcode.cn/problems/minimum-number-of-keypresses/description/

你有一个 9 键键盘，按键按 1 到 9 编号，每个按键对应着几个英文小写字母。你可以决定每个按键对应哪些英文字母，但要满足如下条件：
- 26 个英文小写字母必须全部映射到这 9 个按键上。
- 每个英文字母只能映射到 恰好 一个按键上。
- 每个按键 最多 对应 3 个英文字母。
如果想打出按键上的第一个字母，只需要按一次。如果想打出按键上的第二个字母，则需要按两次，依次类推。
给你一个字符串 s ，返回基于你设计的键盘打出 s 需要的 最少 按键次数。
注意：字母映射到每个按键上，映射的顺序无法进行更改。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成

https://leetcode.cn/problems/minimum-number-of-keypresses/solutions/1485806/xian-tong-ji-mei-ge-zi-fu-de-shu-liang-b-ek7a/
先统计每个字符的数量，然后从高到低排序。尽可能把出现次数多的字符放在第一个，放完
 */